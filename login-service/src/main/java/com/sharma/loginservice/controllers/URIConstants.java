package com.sharma.loginservice.controllers;

/**
 * @author Srivatsa
 * 
 *         URIConstants class contains URI mappings
 *
 */
public class URIConstants {

	private URIConstants() {
		throw new IllegalStateException("URI Constants");
	}

	// Home page URI
	public static final String HOME_PAGE = "/";

	// User URI's
	public static final String REGISTER_USER = "/register";
	public static final String GET_USER_DETAILS = "/auth/user";

	// Access role URI's
	public static final String ASSIGN_USER_ROLE = "/auth/assign-user-role";

	// Role URI's
	public static final String GET_ROLES = "/auth/role/get-roles";
	public static final String CREATE_ROLE = "/auth/role/create";

}
