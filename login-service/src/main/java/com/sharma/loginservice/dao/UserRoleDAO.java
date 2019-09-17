package com.sharma.loginservice.dao;

import java.util.List;

import com.sharma.loginservice.model.UserRole;

public interface UserRoleDAO {

	List<UserRole> getUserRoles(String userId);

	int addUserRole(UserRole userRole);

}
