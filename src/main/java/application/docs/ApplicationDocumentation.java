package application.docs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationDocumentation {
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("application"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());
    }
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API", 
	      "Product store management API", 
	      "last update", 
	      "", 
	      new Contact("SOUKAINA ALLAM",  "soukainaaallam@gmail.com", "Développeuse Full Stack "), 
	      "License of API", "API license URL", Collections.emptyList());
	}
}
