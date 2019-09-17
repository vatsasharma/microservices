package com.sharma.loginservice.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sharma.loginservice.dao.BaseDAO;

@Component
public class JdbcDAO implements BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public <T> T get(String sql, Object[] args, RowMapper<T> rowMapper) {
		return jdbcTemplate.queryForObject(sql, args, rowMapper);
	}

	@Override
	public int create(String sql, Object[] args) {
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int update(String sql, Object[] args) {
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int delete(String sql, Object[] args) {
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public <T> List<T> getList(String sql, Object[] args, RowMapper<T> rowMapper) {
		return jdbcTemplate.query(sql, args, rowMapper);
	}

	@Override
	public String getKey() {
		return UUID.randomUUID().toString();
	}

}
