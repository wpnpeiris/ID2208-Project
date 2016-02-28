/**
 * 
 */
package kth.id2208.data;

/**
 * @author pradeeppeiris
 *
 */
public interface ITranformer {

	/**
	 * 
	 * @param template
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String transform(String template, String data) throws Exception;
}
