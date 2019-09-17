package com.sharma.loginservice.service;

import java.util.List;

import com.sharma.loginservice.model.Role;

public interface RoleService {

	Role create(Role role);

	List<Role> getRoles();
}
