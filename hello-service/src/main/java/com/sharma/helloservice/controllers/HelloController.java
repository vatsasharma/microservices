package com.sharma.helloservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

	@RequestMapping
	public String helloWorld() {
		return "Hello World!";
	}

	@RequestMapping(value = "/{firstName}/{lastName}")
	public String helloUser(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + " welcome to the world of Micro Services";
	}

}
