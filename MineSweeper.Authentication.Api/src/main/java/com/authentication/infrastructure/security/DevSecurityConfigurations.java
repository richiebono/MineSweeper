package com.authentication.infrastructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {

	//Authorization settings
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.and().csrf().disable();

	}

	//Configurations of statistical resources (js, css, images, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
}
