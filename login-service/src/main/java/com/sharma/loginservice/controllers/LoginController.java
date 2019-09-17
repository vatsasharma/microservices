package com.sharma.loginservice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.loginservice.dao.impl.QueryConstants;
import com.sharma.loginservice.model.Role;
import com.sharma.loginservice.model.UserEntity;
import com.sharma.loginservice.model.UserRole;
import com.sharma.loginservice.service.RoleService;
import com.sharma.loginservice.service.UserRoleService;
import com.sharma.loginservice.service.UserService;

/**
 * 
 * @author Srivatsa
 * 
 *         LoginController class handles all requests related to user
 *
 */
@RestController
public class LoginController {

	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RoleService roleService;

	/**
	 * @param userEntity
	 * @return returns message of user creation
	 */
	@PostMapping(value = URIConstants.REGISTER_USER)
	public ResponseEntity<String> register(@RequestBody UserEntity userEntity) {
		LOGGER.info("Registering User : " + userEntity.getUsername());
		UserEntity savedUser = userService.register(userEntity);
		LOGGER.info("User " + savedUser.getUsername() + " created successfully with id : " + savedUser.getId());
		return new ResponseEntity<>("User " + savedUser.getUsername() + " created sucessfully!", HttpStatus.CREATED);
	}

	/**
	 * Request handles assigning user a access role
	 * 
	 * @param userRole
	 * @return returns {@link ResponseEntity}
	 */
	@PostMapping(value = URIConstants.ASSIGN_USER_ROLE)
	public ResponseEntity<String> assignUserRole(@RequestBody UserRole userRole) {
		LOGGER.info("Assigning User : " + userRole.getUserId() + " a role : " + userRole.getRole());
		UserRole savedUserRole = userRoleService.addUserRole(userRole);
		return new ResponseEntity<>("User role assigned to user : " + savedUserRole.getUserId(), HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param user
	 * @return returns user-info {@link UserEntity}}
	 */
	@GetMapping(value = URIConstants.GET_USER_DETAILS)
	public Map<String, Object> user(OAuth2Authentication user) {
		LOGGER.info("Fetching user details");
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return userInfo;
	}

	/**
	 * @return returns @see {@link ResponseEntity} of
	 * @see {@link List} of @see {@link Role}
	 */
	@GetMapping(value = URIConstants.GET_ROLES)
	public ResponseEntity<List<Role>> getRoles() {
		LOGGER.info("Fetching Roles");
		return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
	}

	/**
	 * Method handles creation of @see {@link Role}
	 * 
	 * @param role
	 * @return
	 */
	@PostMapping(value = QueryConstants.CREATE_ROLE)
	public ResponseEntity<String> createRole(@RequestBody Role role) {
		LOGGER.info("Creating Role : " + role.getRole());
		Role savedRole = roleService.create(role);
		LOGGER.info("Role " + savedRole.getRole() + " created successfully with id : " + savedRole.getId());
		return new ResponseEntity<>("Role " + savedRole.getRole() + " created sucessfully!", HttpStatus.CREATED);
	}

}
