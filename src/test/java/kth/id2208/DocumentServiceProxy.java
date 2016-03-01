/**
 * 
 */
package kth.id2208;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
import kth.id2208.service.DocumentOutput;

/**
 * @author pradeeppeiris
 *
 */
public class DocumentServiceProxy {
	private final String ENDPOINT = "http://localhost:8080/";
	
	public DocumentOutput createDocument(String templateId, String data) throws Exception {
		Client client = javax.ws.rs.client.ClientBuilder.newClient();
		WebTarget target = client.target(ENDPOINT);
		Invocation.Builder invocationBuilder = target.path("edox").path("document").queryParam("id", templateId).request();
		Response response = invocationBuilder.post(Entity.entity(data, MediaType.APPLICATION_XML));
		
		ObjectMapper mapper = Jackson.newObjectMapper();
		return mapper.readValue(response.readEntity(String.class), DocumentOutput.class);
	}
}
