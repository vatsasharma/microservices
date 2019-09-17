package com.sharma.loginservice.dao;

import com.sharma.loginservice.model.UserEntity;

public interface UserDAO {

	UserEntity getUserDetails(String username);
	
	int create(UserEntity userEntity);
}
