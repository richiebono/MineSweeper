package com.authentication.api.controllers;

import com.authentication.application.interfaces.ITokenAppService;
import com.authentication.application.models.Login;
import com.authentication.application.models.Token;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication/v1")
@Validated
@Slf4j
@Profile("prod")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private ITokenAppService tokenAppService;

	public AuthenticationController(
			AuthenticationManager authManager,
			ITokenAppService tokenAppService) {
		this.tokenAppService = tokenAppService;
		this.authManager = authManager;
	}

	@PostMapping
	public ResponseEntity<Token> authenticate(@RequestBody @Valid Login form) {
		UsernamePasswordAuthenticationToken login = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(login);
			String token = tokenAppService.generateToken(authentication);
			return ResponseEntity.ok(new Token(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
