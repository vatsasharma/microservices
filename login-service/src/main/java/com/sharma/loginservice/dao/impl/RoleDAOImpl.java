package com.sharma.loginservice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.loginservice.dao.BaseDAO;
import com.sharma.loginservice.dao.RoleDAO;
import com.sharma.loginservice.dao.rowmappers.RoleRowmapper;
import com.sharma.loginservice.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private BaseDAO jdbcDAO;

	@Override
	public List<Role> getRoles() {
		Object[] params = {};
		return jdbcDAO.getList(QueryConstants.GET_ROLES, params, new RoleRowmapper());
	}

	@Override
	public int create(Role role) {
		role.setId(jdbcDAO.getKey());
		Object[] params = { role.getId(), role.getRole() };
		return jdbcDAO.create(QueryConstants.CREATE_ROLE, params);
	}

}
