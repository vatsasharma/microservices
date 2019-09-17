package com.sharma.loginservice.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sharma.loginservice.customexceptions.CreationException;
import com.sharma.loginservice.dao.UserDAO;
import com.sharma.loginservice.dao.UserRoleDAO;
import com.sharma.loginservice.model.CustomUser;
import com.sharma.loginservice.model.UserEntity;
import com.sharma.loginservice.model.UserRole;
import com.sharma.loginservice.service.UserService;

/**
 * @author Srivatsa
 * 
 *         UserServiceImpl class implements {@see UserDetailsService} and
 *         handles user services
 *
 */
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDao;

	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * @param takes username to fetch user details
	 * @return returns {@see UserDetails}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserEntity userEntity = userDao.getUserDetails(username);
		if (userEntity == null) {
			LOGGER.info("User " + username + " not found in the database");
			throw new UsernameNotFoundException(username);
		}
		List<UserRole> userRoles = getUserRoles(userEntity.getId());
		Set<GrantedAuthority> authorities = new HashSet<>();
		if (userRoles != null) {
			for (UserRole userRole : userRoles)
				authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new CustomUser(userEntity.getUsername(), userEntity.getPassword(), authorities);
	}

	/**
	 * @param userId
	 * @return returns {@See list of UserRole}
	 */
	private List<UserRole> getUserRoles(String userId) {
		return userRoleDAO.getUserRoles(userId);
	}

	/**
	 * Method used to register the User
	 * 
	 * @return returns {@See UserEntity}
	 * @throws CreationException
	 */
	@Override
	public UserEntity register(UserEntity userEntity) {
		try {
			userDao.create(userEntity);
			LOGGER.info(userEntity.getUsername() + " registered successfully!");
			return userEntity;
		} catch (Exception e) {
			LOGGER.error("Error registering user with username : " + userEntity.getUsername() + " \nCause: " + e.getMessage());
			throw new CreationException(e.getMessage());
		}
	}

}
