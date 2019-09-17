package com.sharma.loginservice.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sharma.loginservice.model.Role;

public class RoleRowmapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getString("id"));
		role.setRole(rs.getString("role"));
		return role;
	}

}
