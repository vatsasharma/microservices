package com.sharma.loginservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sharma.loginservice.dao.BaseDAO;
import com.sharma.loginservice.dao.UserDAO;
import com.sharma.loginservice.dao.rowmappers.UserRowmapper;
import com.sharma.loginservice.model.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private BaseDAO jdbcDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserEntity getUserDetails(String username) {
		Object[] params = new String[] { username };
		return jdbcDAO.get(QueryConstants.GET_USER_DETAILS, params, new UserRowmapper());
	}

	@Override
	public int create(UserEntity userEntity) {
		userEntity.setId(jdbcDAO.getKey());
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		Object[] params = { userEntity.getId(), userEntity.getUsername(), userEntity.getPassword() };
		return jdbcDAO.create(QueryConstants.CREATE_USER, params);
	}

}
