/**
 * 
 */
package kth.id2208.recommendation;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author pradeeppeiris
 *
 */
public class SAXCreateXPath extends DefaultHandler {
 
    // map of all encountered tags and their running count
    private Map<String, Integer> tagCount;
    // keep track of the succession of elements
    private Stack<String> tags;
 
    // set to the tag name of the recently closed tag
    String lastClosedTag;
 
    /**
     * Construct the XPath expression
     */
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
    public void startElement (String namespaceURI, String localName, String qName, Attributes atts)
        throws SAXException
    {
        boolean isRepeatElement = false;
 
        if (tagCount.get(localName) == null) {
            tagCount.put(localName, 0);
        } else {
            tagCount.put(localName, 1 + tagCount.get(localName));
        }
 
        if (lastClosedTag != null) {
            // an element was recently closed ...
            if (lastClosedTag.equals(localName)) {
                // ... and it's the same as the current one
                isRepeatElement = true;
            } else {
                // ... but it's different from the current one, so discard it
                tags.pop();
            }
        }
 
        // if it's not the same element, add the new element and zero count to list
        if (! isRepeatElement) {
            tags.push(localName);
        }
 
        System.out.println(getCurrentXPath());
        lastClosedTag = null;
    }
 
    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException {
        // if two tags are closed in succession (without an intermediate opening tag),
        // then the information about the deeper nested one is discarded
        if (lastClosedTag != null) {
            tags.pop();
        }
        lastClosedTag = localName;
    }
 
    public static void main (String[] args) throws Exception {

 
        // Create a JAXP SAXParserFactory and configure it
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(false);
 
        // Create a JAXP SAXParser
        SAXParser saxParser = spf.newSAXParser();
 
        // Get the encapsulated SAX XMLReader
        XMLReader xmlReader = saxParser.getXMLReader();
 
        // Set the ContentHandler of the XMLReader
        xmlReader.setContentHandler(new SAXCreateXPath());
 
       
 
        // Tell the XMLReader to parse the XML document
        xmlReader.parse("data/xml/shipment_data1.xml");
    }
}