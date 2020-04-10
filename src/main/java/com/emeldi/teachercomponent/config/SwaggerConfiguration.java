package com.emeldi.teachercomponent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        Contact contact = new Contact(
                "Jan Kuzník",
                "https://github.com/N3ldor3th",
                "KuznikJan@seznam.cz"
        );
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        ApiInfo apiInfo = new ApiInfo(
                "Teacher Component API",
                "This page documents Teacher Component and its endpoints", "1.0",
                null, contact, null, null, vendorExtensions);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
