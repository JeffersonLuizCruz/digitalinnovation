package com.digitalinnovation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.services.PersonServiceImpl;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private final PersonServiceImpl personService;
	
	@Autowired
	public PersonController(PersonServiceImpl personService) {
		this.personService = personService;
	}
	
	

}
