package com.sharma.loginservice.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Srivatsa
 * 
 *         Home controller of Authentication Server
 *
 */
@RestController
public class HomeController {

	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

	/**
	 * @return returns status of a server
	 */
	@GetMapping(value = URIConstants.HOME_PAGE)
	public String home() {
		LOGGER.info("Accessing home page");
		return "Auth server is up!!";
	}

}
