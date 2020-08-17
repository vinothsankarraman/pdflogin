package com.pdf.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.login.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping(value="/{userid}/{password}")
	public boolean validateInputs(@PathVariable String userid, @PathVariable String password) {
		boolean valid =  service.validateInputs(userid, password);
		System.out.println(valid);
		return valid;
	}
	
	@PostMapping(value="/{userid}/{password}")
	public boolean addUser(@PathVariable String userid, @PathVariable String password)
	{
		boolean valid=service.addUser(userid, password);
		return valid;
	}

}
