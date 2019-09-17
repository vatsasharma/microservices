package com.sharma.loginservice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.loginservice.customexceptions.CreationException;
import com.sharma.loginservice.dao.RoleDAO;
import com.sharma.loginservice.model.Role;
import com.sharma.loginservice.service.RoleService;

/**
 * @author Srivatsa
 * 
 *         Service class handles all the logic relate to { @see Role}
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger LOGGER = LogManager.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDAO roleDao;

	/**
	 * Fetches all { @see Roles}
	 */
	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	/**
	 * Creates { @see Role}
	 * 
	 * @throws { @see CreationException}
	 */
	@Override
	public Role create(Role role) {
		try {
			roleDao.create(role);
			LOGGER.info("Role :" + role.getRole() + " added successfully");
			return role;
		} catch (Exception e) {
			LOGGER.error("Error adding role : " + role.getRole() + " \nCause: " + e.getMessage());
			throw new CreationException(e.getMessage());
		}
	}

}
