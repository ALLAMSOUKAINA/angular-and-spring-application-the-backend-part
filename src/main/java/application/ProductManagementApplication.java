package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// encapsulation de trois annotations :@Configuration,@EnableAutoConfiguration,@ComponentScan
//toute les classe doivent etre sous des packages qui commence par com.example.demo   pour pouvoir etre scanner par spring et prendre en considerration les annotations
@SpringBootApplication
@EntityScan(basePackages = {"application.model"})  // scan JPA entities
@EnableSwagger2
public class ProductManagementApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
