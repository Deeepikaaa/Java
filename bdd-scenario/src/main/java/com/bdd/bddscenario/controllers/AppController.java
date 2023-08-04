package com.bdd.bddscenario.controllers;

import javax.security.sasl.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdd.bddscenario.entity.UserLoginEntity;
import com.bdd.bddscenario.model.UserLogin;
import com.bdd.bddscenario.services.UserServices;

@RestController
@RequestMapping("/user")
public class AppController {

	@Autowired
	private UserServices service;

	@PostMapping("/add")
	public UserLoginEntity addUser(@RequestBody UserLoginEntity user) {
		System.out.println("adding user");
		return service.addUser(user);
	}

	@PostMapping("/signin")
	public String checkForUser(@RequestBody UserLogin user) throws AuthenticationException {
	String message = "";
		Boolean isValid=  service.checkForValidity(user.getUserName(), user.getPassword());
		if(isValid) {
			if(user.getAuthentication()) {
				message= "Valid User and access granted";
			}
			else {
				throw new com.bdd.bddscenario.exceptions.AuthenticationException("Okta verification neeeded");
			}
		}
		return message;
	}

}
