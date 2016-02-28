/**
 * 
 */
package kth.id2208.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pradeeppeiris
 *
 */
public class TemplateDAO {

	private static final Logger log = LoggerFactory.getLogger(TemplateDAO.class);
	
	
	
	public void saveTemplate(String templatePath, String content) {
		log.info("Save Template");
		try {
			FileWriter fw = new FileWriter(new File(templatePath));
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			log.error("Error in save template", e);
		}
	}
	
	public List<Template> listTemplates(String templatePath) {
		log.info("List Templates");
		List<Template> templates = new ArrayList<Template>();
		File folder = new File(templatePath);
		File[] templateList = folder.listFiles();
		for(File file: templateList) {
			Template template = new Template();
			template.setId(file.getName());
			templates.add(template);
		}
		
		return templates;
	}
}
