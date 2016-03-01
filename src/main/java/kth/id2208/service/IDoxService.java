/**
 * 
 */
package kth.id2208.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import kth.id2208.dao.Template;

/**
 * @author pradeeppeiris
 *
 */
public interface IDoxService {
	/**
	 * 
	 * @param id
	 * @param content
	 */
	public void createTemplate(String id, String content);
	
	/**
	 * 
	 * @return
	 */
	public List<Template> listTemplates();
	
	/**
	 * 
	 * @param tempateId
	 * @param data
	 * @return
	 */
	public DocumentOutput generateDocument(String tempateId, String data) throws WebApplicationException ;
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws WebApplicationException
	 */
	public DocumentOutput generateDocument(String data) throws WebApplicationException ;
}
