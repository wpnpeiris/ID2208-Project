/**
 * 
 */
package kth.id2208.data;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import kth.id2208.service.DocumentOutput;
import kth.id2208.transform.HTMLTranformer;
import sun.misc.BASE64Decoder;


/**
 * @author pradeeppeiris
 *
 */
public class TestHTMLTransformer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HTMLTranformer transformer = HTMLTranformer.getInstance();
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("data/xml/transcript_1.xml"));
			String data = new String(encoded, Charset.defaultCharset());
			
			DocumentOutput output = transformer.transform("data/xsl/template_transcript_html.xsl", data);
			System.out.println(">>> " + output.getData());
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = decoder.decodeBuffer(output.getData());
			
			
			FileOutputStream stream = new FileOutputStream("data/test/outhtml.html");
			try {
			    stream.write(content);
			} finally {
			    stream.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
