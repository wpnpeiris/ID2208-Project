/**
 * 
 */
package kth.id2208.recommendation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import kth.id2208.Constance;
import kth.id2208.dao.Template;
import kth.id2208.dao.TemplateDAO;
import kth.id2208.util.Levenshtein;
import kth.id2208.xml.SaxProcessor;

/**
 * @author pradeeppeiris
 *
 */
public class TextMatcher {

	private static final Logger log = LoggerFactory.getLogger(TextMatcher.class);

	private final int MAX_LEVENSHTEIN = 10;
	
	private static TextMatcher instance;

	private final TemplateDAO templateDAO = new TemplateDAO();

	private TextMatcher() {

	}

	public static TextMatcher getInstance() {
		if (instance == null) {
			instance = new TextMatcher();
		}

		return instance;
	}

	public List<Template> match(String data) throws Exception {
		log.info("Start text matcher for data: " + data);

		Set<String> selectedDataXPaths = dataXPathSelection(data);
		Map<Template, Set<String>> templateNodeSelection = templateTextSelection();
		
		List<Template> matches = new ArrayList<Template>();
		
		for (Template template : templateNodeSelection.keySet()) {
			int score = 0;
			for (String templateText : templateNodeSelection.get(template)) {
				int minDistance = 100000;
				String tmp = null;
				int lin;
				for (String xpath : selectedDataXPaths) {
					if((lin = Levenshtein.distance(templateText, xpath)) < minDistance) {
						minDistance = lin;
						tmp = xpath;
					}
				}
				
				if(minDistance < MAX_LEVENSHTEIN ) {
					score++;
				}
			}
			template.setScore(Double.valueOf(score));
			matches.add(template);
		}
		Collections.sort(matches);
		return matches;
	}

	private Set<String> dataXPathSelection(String data) throws Exception {
		final Set<String> selectedXPaths = new HashSet<String>();

		SaxProcessor saxProcessor = SaxProcessor.getInstance();
		saxProcessor.parse(data, new DefaultHandler() {
			Map<String, Integer> tagCount;
			Stack<String> tags;
			String lastClosedTag;

			private String getCurrentXPath() {
				String str = "/";
				boolean first = true;
				for (String tag : tags) {
					if (first)
						str = str + tag;
					else
						str = str + "/" + tag;
					first = false;
				}
				return str;
			}

			@Override
			public void startDocument() throws SAXException {
				tags = new Stack();
				tagCount = new HashMap<String, Integer>();
			}

			@Override
			public void startElement(String namespaceURI, String localNamex, String qName, Attributes atts)
					throws SAXException {
				boolean isRepeatElement = false;

				if (tagCount.get(qName) == null) {
					tagCount.put(qName, 0);
				} else {
					tagCount.put(qName, 1 + tagCount.get(qName));
				}

				if (lastClosedTag != null) {
					if (lastClosedTag.equals(qName)) {
						isRepeatElement = true;
					} else {
						tags.pop();
					}
				}

				if (!isRepeatElement) {
					tags.push(qName);
				}

				selectedXPaths.add(getCurrentXPath());
				lastClosedTag = null;
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (lastClosedTag != null) {
					tags.pop();
				}
				lastClosedTag = qName;
			}

		});

		return selectedXPaths;
	}

	private Map<Template, Set<String>> templateTextSelection() throws Exception {
		List<Template> templates = templateDAO.listTemplates(Constance.TEMPLATE_BASE_PATH);
		Map<Template, Set<String>> templateSelections = new HashMap<Template, Set<String>>();
		for (Template template : templates) {
			log.info("Process template: " + template);
			final Set<String> templateVals = new HashSet<String>();

			SaxProcessor saxProcessor = SaxProcessor.getInstance();
			saxProcessor.parse(new File(Constance.TEMPLATE_BASE_PATH + template.getId()), new DefaultHandler() {
				String currentElement;
				String selectValue;

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					currentElement = qName;
					selectValue = attributes.getValue("select");
				}

				public void endElement(String uri, String localName, String qName) throws SAXException {

				}

				public void characters(char ch[], int start, int length) throws SAXException {
					if (selectValue != null) {
						templateVals.add(selectValue);
					}
				}

			});

			templateSelections.put(template, templateVals);
		}

		return templateSelections;
	}
}
