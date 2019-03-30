package com.example.uk.ford.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Swagger2Properties swagger2PropertyDetails;

    @Autowired
    public SwaggerConfig(Swagger2Properties swagger2PropertyDetails){
        this.swagger2PropertyDetails = swagger2PropertyDetails;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("com.example.springboot.cloud"))
                .paths(PathSelectors.any())
                //.paths(regex("/cloud/dynamoDb.*"))
                .build()
                .apiInfo(apiInfo());
    }
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title(swagger2PropertyDetails.getTitle())
                    .description(swagger2PropertyDetails.getDescription())
                    .termsOfServiceUrl(swagger2PropertyDetails.getTermsOfServiceUrl())
                    .contact(
                            new Contact(
                                    swagger2PropertyDetails.getName(),
                                    swagger2PropertyDetails.getUrl(),
                                    swagger2PropertyDetails.getEmail()
                            )
                    )
                    .license(swagger2PropertyDetails.getLicense())
                    .licenseUrl(swagger2PropertyDetails.getLicenseUrl())
                    .version(swagger2PropertyDetails.getVersion())
                    .build();
        }

}
