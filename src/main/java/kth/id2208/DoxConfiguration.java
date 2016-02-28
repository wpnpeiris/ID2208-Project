/**
 * 
 */
package kth.id2208;

import io.dropwizard.Configuration;

/**
 * @author pradeeppeiris
 *
 */
public class DoxConfiguration extends Configuration {
	private String defaultName;

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
}
