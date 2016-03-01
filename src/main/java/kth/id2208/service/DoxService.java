/**
 * 
 */
package kth.id2208.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kth.id2208.Constance;
import kth.id2208.dao.Template;
import kth.id2208.dao.TemplateDAO;
import kth.id2208.recommendation.TemplateRecommender;
import kth.id2208.transform.DataTransformFactory;
import kth.id2208.transform.XSLTranformer;

/**
 * @author pradeeppeiris
 *
 */
public class DoxService implements IDoxService {
	
	private static final Logger log = LoggerFactory.getLogger(DoxService.class);
	
	
	
	private final TemplateDAO templateDAO = new TemplateDAO();
	
	private final TemplateRecommender recommender = new TemplateRecommender();
	
	public void createTemplate(String id, String content) {
		log.info("Create Template: " + id);
		templateDAO.saveTemplate(Constance.TEMPLATE_BASE_PATH + id + ".xsl", content);
	}
	
	public List<Template> listTemplates() {
		log.info("Find all Templates");
		return templateDAO.listTemplates(Constance.TEMPLATE_BASE_PATH);
	}
	
	public DocumentOutput generateDocument(String tempateId, String data) throws WebApplicationException {
		log.info("Generate Document for the selected template: " + tempateId);
		try {
			String templatePath = Constance.TEMPLATE_BASE_PATH + tempateId + ".xsl";
			XSLTranformer transformer = DataTransformFactory.getTransformer(templatePath);
			return transformer.transform(templatePath, data);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	public DocumentOutput generateDocument(String data) throws WebApplicationException {
		log.info("Generate Document for auto selected template");
		try {
			List<Template> templates = recommender.recommend(data);
			log.info("Recommended Templates: ");
			for(Template template: templates) {
				log.info("Template: " + template.getId() + ", Score: " + template.getScore());
			}
			
			Template topTemplate = templates.get(0);
			log.info("Select Document with the highest score for rendering: " + topTemplate.getId() + " " + topTemplate.getScore());
			String templatePath = Constance.TEMPLATE_BASE_PATH + topTemplate.getId();
			XSLTranformer transformer = DataTransformFactory.getTransformer(templatePath);
			
			return transformer.transform(templatePath, data);
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
