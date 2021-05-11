package com.minesweeper;

import com.minesweeper.application.interfaces.IMineSweeperAppService;
import com.minesweeper.application.interfaces.ITokenAppService;
import com.minesweeper.application.services.MineSweeperAppService;
import com.minesweeper.application.services.TokenAppService;
import com.minesweeper.domain.interfaces.IMineSweeperService;
import com.minesweeper.domain.services.MineSweeperService;
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
public class MinesweeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Bean
	public IMineSweeperAppService mineSweeperAppService() { return new MineSweeperAppService();	}

	@Bean
	public ITokenAppService tokenAppService() { return new TokenAppService();	}

}
