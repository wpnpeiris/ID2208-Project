/**
 * 
 */
package kth.id2208;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import kth.id2208.service.DocumentOutput;
import sun.misc.BASE64Decoder;

/**
 * @author pradeeppeiris
 *
 */
public class DocumentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentServiceProxy docProxy = new DocumentServiceProxy();
		
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("data/test/transcript_1.xml"));
			DocumentOutput output = docProxy.createDocument("template1", new String(encoded, StandardCharsets.UTF_8));
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = decoder.decodeBuffer(output.getData());

			FileOutputStream stream = new FileOutputStream("data/test/out66." + output.getType());

			try {
			    stream.write(content);
			} finally {
			    stream.close();
			}
		} catch (Exception e) {

		}

		
	}

}
