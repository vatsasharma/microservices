package com.sharma.loginservice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.loginservice.dao.BaseDAO;
import com.sharma.loginservice.dao.UserRoleDAO;
import com.sharma.loginservice.dao.rowmappers.UserRoleRowmapper;
import com.sharma.loginservice.model.UserRole;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	private BaseDAO jdbcDAO;

	@Override
	public List<UserRole> getUserRoles(String userId) {
		Object[] params = new String[] { userId };
		return jdbcDAO.getList(QueryConstants.GET_USER_ROLES, params, new UserRoleRowmapper());
	}

	@Override
	public int addUserRole(UserRole userRole) {
		userRole.setId(jdbcDAO.getKey());
		Object[] args = { userRole.getId(), userRole.getUserId(), userRole.getRole() };
		return jdbcDAO.create(QueryConstants.CREATE_USER_ROLE, args);
	}

}
