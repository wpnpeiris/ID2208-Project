/**
 * 
 */
package kth.id2208;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerDropwizard;
import kth.id2208.resource.DoxResource;
import kth.id2208.service.DoxService;
import kth.id2208.service.IDoxService;

/**
 * @author pradeeppeiris
 *
 */
public class DoxApplication extends Application<DoxConfiguration> {

	private static final Logger log = LoggerFactory.getLogger(DoxApplication.class);
	
	private final SwaggerDropwizard swagger = new SwaggerDropwizard();
	
	 @Override
	 public void initialize(Bootstrap<DoxConfiguration> bootstrap) {
		 swagger.onInitialize(bootstrap); 
	 }
	 
	@Override
	public void run(DoxConfiguration cnf, Environment env) throws Exception {
		final IDoxService doxService = new DoxService();
		final DoxResource doxResource = new DoxResource(doxService);
		env.jersey().register(doxResource);
		
		swagger.onRun(cnf, env, "localhost");
	}
	
	public static void main(String[] args) throws Exception {
		log.info("Start eDox Application");
		new DoxApplication().run(args);
	}

}
