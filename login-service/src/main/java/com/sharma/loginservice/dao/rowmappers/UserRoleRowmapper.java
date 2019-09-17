package com.sharma.loginservice.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sharma.loginservice.model.UserRole;

public class UserRoleRowmapper implements RowMapper<UserRole> {

	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRole userRole = new UserRole();
		userRole.setId(rs.getString("id"));
		userRole.setUserId(rs.getString("user_id"));
		userRole.setRole(rs.getString("role"));
		return userRole;
	}

}
