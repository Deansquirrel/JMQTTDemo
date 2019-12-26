package com.yuansong.study.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yuansong.study.common.config.SwaggerConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	
	private static final Logger logger = LoggerFactory.getLogger(Swagger.class);
	
//	@Value("${project.version}")
//	private String version;
	
//	@Value("${name}")
//	private String name;
	
	
	@Autowired
	private SwaggerConfig swaggerConfig;
	
	@Bean
	public Docket createRestApi() {
		logger.info("SwaggerConfig createRestApi 构建REST API");
		logger.info("Swagger启用标志: {}",this.swaggerConfig.isEnable());
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(this.swaggerConfig.isEnable())
				.apiInfo(this.apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yuansong.study"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		logger.info("SwaggerConfig apiInfo API信息");
		return new ApiInfoBuilder()
				.title(this.swaggerConfig.getTitle())
				.description(this.swaggerConfig.getDescription())
				.version(this.swaggerConfig.getVersion())
				.build();
	}

}
