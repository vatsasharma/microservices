package com.sharma.loginservice.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.loginservice.customexceptions.CreationException;
import com.sharma.loginservice.dao.UserRoleDAO;
import com.sharma.loginservice.model.UserRole;
import com.sharma.loginservice.service.UserRoleService;

/**
 * @author Srivatsa
 * 
 *         Service class handles all the logic related to @see {@link UserRole}
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	private static final Logger LOGGER = LogManager.getLogger(UserRoleServiceImpl.class);

	@Autowired
	private UserRoleDAO userRoleDao;

	/**
	 * Method to assign a access role to user
	 * 
	 * @throws @see {@link CreationException}
	 */
	@Override
	public UserRole addUserRole(UserRole userRole) {
		try {
			userRoleDao.addUserRole(userRole);
			LOGGER.info("User role : " + userRole.getRole() + " assigned to user :" + userRole.getUserId());
			return userRole;
		} catch (Exception e) {
			LOGGER.error("Error adding access role to  : " + userRole.getUserId() + " \nCause: " + e.getMessage());
			throw new CreationException(e.getMessage());
		}
	}

}
