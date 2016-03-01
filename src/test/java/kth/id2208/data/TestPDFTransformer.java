/**
 * 
 */
package kth.id2208.data;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import kth.id2208.service.DocumentOutput;
import kth.id2208.transform.PDFTransformer;
import sun.misc.BASE64Decoder;

/**
 * @author pradeeppeiris
 *
 */
public class TestPDFTransformer {
	public static void main(String[] args) {
		PDFTransformer transformer = PDFTransformer.getInstance();
		try {
			
			byte[] encoded = Files.readAllBytes(Paths.get("data/xml/shipment_data1.xml"));  
			String data = new String(encoded, Charset.defaultCharset()); //"<name>Pradeep</name>";
			
			DocumentOutput output = transformer.transform("data/xsl/template_text_pdf.xsl", data);
			
			System.out.println(output);
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = decoder.decodeBuffer(output.getData());
			
			
			FileOutputStream stream = new FileOutputStream("data/test/out7.pdf");
			try {
			    stream.write(content);
			} finally {
			    stream.close();
			}
			
//			System.out.println(output);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
