package com.sharma.loginservice.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	private static final long serialVersionUID = 1L;

	public CustomUser(String username, String password, Set<GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

}
