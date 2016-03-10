/**
 * 
 */
package kth.id2208.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kth.id2208.dao.Template;
import kth.id2208.service.DocumentOutput;

/**
 * @author pradeeppeiris
 *
 */
public class DocumentProxy {
	
	private final String ENDPOINT = "http://localhost:8080/";
	private static DocumentProxy instance;
	private Client client;
	
	private DocumentProxy() {
		client = ClientBuilder.newClient();
	}
	
	public static DocumentProxy getInstance() {
		if(instance == null) {
			instance = new DocumentProxy();
		}
		
		return instance;
	}
	
	public List<Template> listDocument() throws Exception {
		WebTarget target = client.target(ENDPOINT);
		Invocation.Builder invocationBuilder = target.path("edox").path("template").request();
		Response response = invocationBuilder.get();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.readValue(response.readEntity(String.class), new TypeReference<List<Template>>() {});
	}
	
	public DocumentOutput createDocument(String template, String data) throws Exception {
		WebTarget target = client.target(ENDPOINT);
		Invocation.Builder invocationBuilder = target.path("edox").path("document").path(template).request();
		Response response = invocationBuilder.post(Entity.entity(data, MediaType.APPLICATION_XML_TYPE));
		DocumentOutput output = null;
		
		if (response.getStatus() == 200) {
			ObjectMapper objectMapper = new ObjectMapper();
			output =  objectMapper.readValue(response.readEntity(String.class), DocumentOutput.class);
		}
		return output;
	}
	
	public DocumentOutput createDocument(String data) throws Exception {
		WebTarget target = client.target(ENDPOINT);
		Invocation.Builder invocationBuilder = target.path("edox").path("document").request();
		Response response = invocationBuilder.post(Entity.entity(data, MediaType.APPLICATION_XML_TYPE));
		DocumentOutput output = null;
		
		if (response.getStatus() == 200) {
			ObjectMapper objectMapper = new ObjectMapper();
			output =  objectMapper.readValue(response.readEntity(String.class), DocumentOutput.class);
		}
		return output;
	}
}
