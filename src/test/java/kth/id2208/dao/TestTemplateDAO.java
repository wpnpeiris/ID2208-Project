/**
 * 
 */
package kth.id2208.dao;

/**
 * @author pradeeppeiris
 *
 */
public class TestTemplateDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateDAO dao = new TemplateDAO();
		dao.saveTemplate("test", "test xml");
	}

}
