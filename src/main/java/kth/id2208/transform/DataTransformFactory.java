/**
 * 
 */
package kth.id2208.transform;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import kth.id2208.service.DoxService;

/**
 * @author pradeeppeiris
 *
 */
public class DataTransformFactory {
	
	private static final String XSLT_NS = "http://www.w3.org/1999/XSL/Transform";
	private static final String XSLFO_NS = "http://www.w3.org/1999/XSL/Format";
	
	private static final Logger log = LoggerFactory.getLogger(DataTransformFactory.class);
	
	public static XSLTranformer getTransformer(String templatePath) throws Exception {
		TemplateType type = getTransformerType(templatePath);
		log.info("Selected Transformer: " + type);
		
		XSLTranformer transformer = null;
		switch(type) {
		case HTML:
			transformer = HTMLTranformer.getInstance();
			break;
		case PDF:
			transformer = PDFTransformer.getInstance();
			break;
		case UNKNOWN:
			transformer = HTMLTranformer.getInstance();
			break;
		}
		return transformer;
	}
	
	private static TemplateType getTransformerType(String templatePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(templatePath));
		Element element = document.getDocumentElement();
		NamedNodeMap map = element.getAttributes();
		
		boolean isXSL = false;
		boolean isFO = false;
		for(int i = 0; i < map.getLength(); i++) {
			if(XSLT_NS.equals(map.item(i).getTextContent())) {
				isXSL = true;
			}
			
			if(XSLFO_NS.equals(map.item(i).getTextContent())) {
				isFO = true;
			}
		}
		
		TemplateType type;
		if(isXSL && isFO) {
			type = TemplateType.PDF;
		} else if(isXSL) {
			type = TemplateType.HTML;
		} else {
			type = TemplateType.UNKNOWN;
		}
		
		return type;
	}
	
}
