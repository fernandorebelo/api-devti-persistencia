package com.devti.aula.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.devti.aula.resource"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("API de persistência de dados de cidades e clientes")
    			.description("Exemplo de aplicação Spring Boot REST API")
    			.version("1.0.0")
    			.license("Apache 2.0")
    			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
    			.contact(new Contact("Fernando Rebelo", "https://www.linkedin.com/in/fernandorebelodev/", "fernandorebelo.dev@gmail.com"))
    			.build();
    }
}