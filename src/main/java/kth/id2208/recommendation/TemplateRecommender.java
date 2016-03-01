/**
 * 
 */
package kth.id2208.recommendation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kth.id2208.dao.Template;

/**
 * @author pradeeppeiris
 *
 */
public class TemplateRecommender {

	private static final Logger log = LoggerFactory.getLogger(TemplateRecommender.class);
	
	public List<Template> recommend(String data) throws Exception {
		log.info("Recommend Templates");
		return TextMatcher.getInstance().match(data);
	}
	
}
