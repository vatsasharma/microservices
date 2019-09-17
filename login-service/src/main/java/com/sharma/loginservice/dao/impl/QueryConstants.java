package com.sharma.loginservice.dao.impl;

/**
 * 
 * @author Srivatsa
 * 
 *         QueryConstants is a util's class which contains all the queries
 */
public class QueryConstants {

	/**
	 * private constructor
	 */
	private QueryConstants() {
		throw new IllegalStateException("Utility class");
	}

	// User based queries
	public static final String CREATE_USER = "INSERT INTO users VALUES(?,?,?)";
	public static final String GET_USER_DETAILS = "SELECT * FROM users WHERE username = ?";

	// User-Role related queries
	public static final String GET_USER_ROLES = "SELECT * FROM user_roles WHERE user_id = ?";
	public static final String CREATE_USER_ROLE = "INSERT INTO user_roles values(?,?,?)";

	// Role related queries
	public static final String CREATE_ROLE = "INSERT INTO roles VALUES(?,?)";
	public static final String GET_ROLES = "SELECT * FROM roles";

}
