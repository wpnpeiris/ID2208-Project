/**
 * 
 */
package kth.id2208.util;

import sun.misc.BASE64Encoder;

/**
 * @author pradeeppeiris
 *
 */
public class B64Encoder {

	public static String encode(String content) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(content.getBytes());
	}
	
	public static String encode(byte[] content) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(content);
	}
}
