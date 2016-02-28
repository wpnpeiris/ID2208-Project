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
import kth.id2208.data.DataTransformFactory;
import kth.id2208.data.ITranformer;
import kth.id2208.data.TransformerType;

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
	
	public String generateDocument(String tempateId, String data) throws WebApplicationException {
		log.info("Generate Document");
		ITranformer transformer = DataTransformFactory.getTransformer(TransformerType.HTML);
		try {
			return transformer.transform(TEMPLATE_BASE_PATH + tempateId + ".xsl", data);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
