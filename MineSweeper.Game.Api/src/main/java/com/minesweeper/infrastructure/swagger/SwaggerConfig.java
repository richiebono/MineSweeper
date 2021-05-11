package com.minesweeper.infrastructure.swagger;

import com.minesweeper.domain.entity.User;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.apiInfo(apiInfo())
				.ignoredParameterTypes(User.class)
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
								.name("Authorization")
								.description("Header to token JWT")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"MineSweeper",
				"Deviget Challenge",
				"API V1",
				null,
				null,
				null, null, Collections.emptyList());
	}
}
