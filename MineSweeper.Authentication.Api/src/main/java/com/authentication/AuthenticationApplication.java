package com.authentication;

import com.authentication.application.interfaces.ITokenAppService;
import com.authentication.application.interfaces.IUserAppService;
import com.authentication.application.services.UserAppService;
import com.authentication.application.services.TokenAppService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Bean
	public IUserAppService userAppService() { return new UserAppService();	}

	@Bean
	public ITokenAppService tokenAppService() { return new TokenAppService();	}

}
