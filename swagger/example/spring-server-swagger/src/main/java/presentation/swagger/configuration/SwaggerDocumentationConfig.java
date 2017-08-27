package presentation.swagger.configuration;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;


//@Component
public class SwaggerDocumentationConfig extends ResourceConfig {

    public SwaggerDocumentationConfig() {
        configureSwagger();
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.0.1");
        beanConfig.setBasePath("/rrt/rest");
        beanConfig.setResourcePackage("hr.ogcs.rrt.service.rest");
        beanConfig.setPrettyPrint("true");
        beanConfig.setScan(true);
    }
}