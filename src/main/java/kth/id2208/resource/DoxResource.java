/**
 * 
 */
package kth.id2208.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import kth.id2208.dao.Template;
import kth.id2208.service.IDoxService;

/**
 * @author pradeeppeiris
 *
 */
@Path("/edox")
@Api(consumes="application/xml", value = "/edox", description = "eDocument Service" )
public class DoxResource {

	private static final Logger log = LoggerFactory.getLogger(DoxResource.class);

	private final IDoxService doxService;

	public DoxResource(IDoxService doxService) {
		this.doxService = doxService;
	}

	@POST
	@Timed
	@ApiOperation(consumes="application/xml", value = "Publish a document template", notes = "API for publishing a document template")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@Path("/template")
	@Consumes(MediaType.APPLICATION_XML)
	public void publishTemplate(@ApiParam(value = "Template Id", required = true) @QueryParam("id") String id,
			@ApiParam(value = "Template to publish", required = true) String templateContent) {
		log.info("Publish document template");

		doxService.createTemplate(id, templateContent);
	}
	
	@GET
	@Timed
	@ApiOperation(produces="application/json", value = "List all document templates", 
	notes = "API for listing all document templates",
	response=Template.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@Path("/template")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Template> listTemplate() {
		log.info("Find all document templates");
		
		return doxService.listTemplates();
	}
	
	@POST
	@Timed
	@ApiOperation(consumes="application/xml", value = "Generate document", notes = "API for generating document")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@Path("/document")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String generateDocument(@ApiParam(value = "Template Id", required = true) @QueryParam("id") String id,
			@ApiParam(value = "Document Data", required = true) String data) {
		log.info("Genrate document");

		return doxService.generateDocument(id, data);
	}
}
