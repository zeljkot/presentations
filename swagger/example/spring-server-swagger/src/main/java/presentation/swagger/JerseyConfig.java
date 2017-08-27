package presentation.swagger;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JerseyConfig extends ResourceConfig {

    JerseyConfig() {
        register(PersonsApiController.class);
        System.out.println("### registering PersonsApiController");
    }

    @PostConstruct
    public void init() {
        this.configureSwagger();
    }

    private void configureSwagger() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.0.1");
        beanConfig.setBasePath("/persons");
        beanConfig.setResourcePackage("presentation.swagger");
        beanConfig.setPrettyPrint("true");
        //beanConfig.setScan(true);
    }
}
