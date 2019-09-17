package com.sharma.loginservice.model;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String userId;
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRole() {
	}

	public UserRole(String id, String userId, String role) {
		this.id = id;
		this.userId = userId;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId + ", role=" + role + "]";
	}

}
