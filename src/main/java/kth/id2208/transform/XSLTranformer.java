/**
 * 
 */
package kth.id2208.transform;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import kth.id2208.service.DocumentOutput;

/**
 * @author pradeeppeiris
 *
 */
public abstract class XSLTranformer {

	protected String xslTransform(String template, String data) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(template));
		Transformer transformer = factory.newTransformer(xslt);
		
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		transformer.transform(new StreamSource(new StringReader(data)), result);
		
		return writer.toString();
	}
	
	/**
	 * 
	 * @param template
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public abstract DocumentOutput transform(String template, String data) throws Exception;
}
