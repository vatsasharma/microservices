package com.sharma.loginservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sharma.loginservice.dao.UserRoleDAO;
import com.sharma.loginservice.model.UserRole;
import com.sharma.loginservice.service.impl.UserRoleServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@DisplayName("Test for User Role Service")
public class UserRoleServiceTest {

	@Mock
	private UserRoleDAO userRoleDAO;

	@InjectMocks
	private UserRoleService userRoleService = new UserRoleServiceImpl();

	@Test
	public void Given_UserRole_When_AddUserRole_Then_Return1() {
		// Given
		UserRole userRole = new UserRole("1234", "1", "ADMIN");

		// When
		when(userRoleDAO.addUserRole(userRole)).thenReturn(1);

		// Then
		UserRole expected = new UserRole("1234", "1", "ADMIN");
		assertEquals(expected.toString(), userRoleService.addUserRole(userRole).toString());
		verify(userRoleDAO, times(1)).addUserRole(userRole);
	}

	@Test
	public void Given_InvalidUserRole_When_AddUserRole_Then_ThrowsException() {
		// Given
		UserRole userRole = null;

		// When
		when(userRoleDAO.addUserRole(userRole)).thenThrow(NullPointerException.class);

		// Then
		Assertions.assertThrows(Exception.class, () -> {
			userRoleService.addUserRole(userRole);
		});
		verify(userRoleDAO, times(1)).addUserRole(null);
	}

}
