/**
 * 
 */
package kth.id2208.xml;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author pradeeppeiris
 *
 */
public class SaxProcessor {
	private static SaxProcessor instance;
	
	private SAXParser saxParser;
	
	private SaxProcessor() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		saxParser = factory.newSAXParser();
		
	}
	
	public static SaxProcessor getInstance() throws Exception {
		if(instance == null) {
			instance = new SaxProcessor();
		}
		
		return instance;
	}
	
	public void parse(File file, DefaultHandler handler) throws Exception {
		saxParser.parse(file, handler);
	}
	
	public void parse(String data, DefaultHandler handler) throws Exception {
		saxParser.parse(new InputSource(new StringReader(data)), handler);
	}
}
