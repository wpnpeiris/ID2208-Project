/**
 * 
 */
package kth.id2208.data;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author pradeeppeiris
 *
 */
public class HTMLTranformer implements ITranformer {
	private static HTMLTranformer instance;
	
	private HTMLTranformer(){
		
	}
	
	public static HTMLTranformer getInstance() {
		if(instance == null) {
			instance = new HTMLTranformer();
		}
		return instance;
	}
	
	public String transform(String template, String data) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(template));
		Transformer transformer = factory.newTransformer(xslt);
		
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		transformer.transform(new StreamSource(new StringReader(data)), result);
		
		return writer.toString();
	}
}
