/**
 * 
 */
package kth.id2208.transform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kth.id2208.service.DocumentOutput;
import kth.id2208.util.B64Encoder;

/**
 * @author pradeeppeiris
 *
 */
public class HTMLTranformer extends XSLTranformer {
	
	private static final Logger log = LoggerFactory.getLogger(HTMLTranformer.class);
	
	private static HTMLTranformer instance;
	
	private HTMLTranformer(){
		
	}
	
	public static HTMLTranformer getInstance() {
		if(instance == null) {
			instance = new HTMLTranformer();
		}
		return instance;
	}
	
	public DocumentOutput transform(String template, String data) throws Exception {
		log.info("Transform to HTML Document: " + template);
		DocumentOutput output = new DocumentOutput();
		output.setType("html");
		output.setData(B64Encoder.encode(xslTransform(template, data)));
		return output;
	}
}
