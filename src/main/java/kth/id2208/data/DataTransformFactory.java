/**
 * 
 */
package kth.id2208.data;

/**
 * @author pradeeppeiris
 *
 */
public class DataTransformFactory {
	
	public static ITranformer getTransformer(TransformerType type) {
		ITranformer transformer;
		switch(type) {
		case HTML:
			transformer = HTMLTranformer.getInstance();
		case PDF:
			transformer = HTMLTranformer.getInstance();
		default:
			transformer = HTMLTranformer.getInstance();
		}
		return transformer;
	}
}
