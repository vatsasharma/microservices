package com.sharma.loginservice.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public interface BaseDAO {

	<T> T get(String sql, Object[] args, RowMapper<T> rowMapper);

	int create(String sql, Object[] args);

	int update(String sql, Object[] args);

	int delete(String sql, Object[] args);

	<T> List<T> getList(String sql, Object[] args, RowMapper<T> rowMapper);
	
	String getKey();

}
