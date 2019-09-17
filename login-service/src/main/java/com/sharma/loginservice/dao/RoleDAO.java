package com.sharma.loginservice.dao;

import java.util.List;

import com.sharma.loginservice.model.Role;

public interface RoleDAO {

	int create(Role role);

	List<Role> getRoles();

}
