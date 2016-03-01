/**
 * 
 */
package kth.id2208.recommendation;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import kth.id2208.dao.Template;

/**
 * @author pradeeppeiris
 *
 */
public class TestTextMatcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("data/xml/shipment_data1.xml"));  
			String data = new String(encoded, Charset.defaultCharset());
			
			List<Template> templates = TextMatcher.getInstance().match(data);
			for(Template template: templates) {
				System.out.println(template.getId() + " " + template.getScore());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
