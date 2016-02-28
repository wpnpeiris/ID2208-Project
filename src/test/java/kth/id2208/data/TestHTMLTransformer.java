/**
 * 
 */
package kth.id2208.data;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


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
			byte[] encoded = Files.readAllBytes(Paths.get("data/test/transcript_1.xml"));
			String data = new String(encoded, Charset.defaultCharset());
			
			String output = transformer.transform("data/xsl/transcript.xsl", data);
			System.out.println(">>> " + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
