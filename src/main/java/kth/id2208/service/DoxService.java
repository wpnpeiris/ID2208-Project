/**
 * 
 */
package kth.id2208.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kth.id2208.dao.Template;
import kth.id2208.dao.TemplateDAO;
import kth.id2208.transform.DataTransformFactory;
import kth.id2208.transform.XSLTranformer;

/**
 * @author pradeeppeiris
 *
 */
public class DoxService implements IDoxService {
	
	private static final Logger log = LoggerFactory.getLogger(DoxService.class);
	
	private final String TEMPLATE_BASE_PATH = "data/xsl/";
	
	private final TemplateDAO templateDAO = new TemplateDAO();
	
	public void createTemplate(String id, String content) {
		log.info("Create Template: " + id);
		templateDAO.saveTemplate(TEMPLATE_BASE_PATH + id + ".xsl", content);
	}
	
	public List<Template> listTemplates() {
		log.info("Find all Templates");
		return templateDAO.listTemplates(TEMPLATE_BASE_PATH);
	}
	
	public DocumentOutput generateDocument(String tempateId, String data) throws WebApplicationException {
		log.info("Generate Document");
		try {
			String templatePath = TEMPLATE_BASE_PATH + tempateId + ".xsl";
			XSLTranformer transformer = DataTransformFactory.getTransformer(templatePath);
			return transformer.transform(templatePath, data);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
