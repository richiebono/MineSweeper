package com.authentication.api.controllers;

import com.authentication.application.models.UserViewModel;
import com.authentication.application.services.UserAppService;

import com.authentication.domain.exception.UserException;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication/v1")
@Validated
@Slf4j
@Profile("prod")
public class UserController {
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	UserAppService userAppService;

	@GetMapping("/users")
	public ResponseEntity getAllUsers(Pageable pageable) {
		try {
			// Get a stores board game for an user.
			return ResponseEntity.ok(userAppService.findAll(pageable));
		} catch (UserException e) {
			log.error("User not found", pageable, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody UserViewModel User) {

		try {
			// Get a stores board game for an user.
			return ResponseEntity.ok(userAppService.save(User));
		} catch (UserException e) {
			log.error("User not found", User, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@GetMapping("/users/{id}")
	public ResponseEntity getUserById(@PathVariable(value = "id") Long UserId) {

		try {
			// Get a stores board game for an user.
			return ResponseEntity.ok(userAppService.findById(UserId));
		} catch (UserException e) {
			log.error("User not found", UserId, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@PutMapping("/users/{id}")
	public ResponseEntity updateUser(@PathVariable(value = "id") Long UserId,
			@Valid @RequestBody UserViewModel UserDetails) {

		try {
			UserViewModel userViewModel = userAppService.findById(UserId);

			userViewModel.setName(UserDetails.getEmail());
			userViewModel.setName(UserDetails.getEmail());
			userViewModel.setPassword(UserDetails.getPassword());
			userViewModel.setProfiles(UserDetails.getProfiles());
			userViewModel.setProfiles(UserDetails.getProfiles());

			UserViewModel updatedUser = userAppService.save(userViewModel);

			return ResponseEntity.ok(updatedUser);
		} catch (UserException e) {
			log.error("User not found", UserId, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long UserId) {

		try {
			UserViewModel User = userAppService.findById(UserId);
			userAppService.delete(User);
			return ResponseEntity.ok().build();
		} catch (UserException e) {
			log.error("User not found", UserId, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

}
