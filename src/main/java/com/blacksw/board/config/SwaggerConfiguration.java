package com.blacksw.board.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	private static final String API_TITLE ="private board service API";
	private static final String API_VERSION = "1.0.0";
	private static final String API_DESCRIPTION = "private board service API";
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.blacksw.board"))
				.paths(PathSelectors.any())
				.build();
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(API_TITLE)
				.version(API_VERSION)
				.description(API_DESCRIPTION)
				.build();
	}
	
}
