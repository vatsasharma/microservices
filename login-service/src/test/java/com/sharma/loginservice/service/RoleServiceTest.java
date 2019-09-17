package com.sharma.loginservice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sharma.loginservice.dao.RoleDAO;
import com.sharma.loginservice.model.Role;
import com.sharma.loginservice.service.impl.RoleServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@DisplayName("Test for Role Service")
public class RoleServiceTest {

	@Mock
	private RoleDAO roleDao;

	@InjectMocks
	private RoleService roleService = new RoleServiceImpl();

	@Test
	public void Given_Nothing_When_GetRoles_Then_ReturnsAllRoles() {
		// Given nothing
		// When
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("1", "ADMIN"));
		roles.add(new Role("2", "USER"));
		when(roleDao.getRoles()).thenReturn(roles);

		// Then
		List<Role> actual = roleService.getRoles();
		assertThat(actual.size(), is(2));
		verify(roleDao, times(1)).getRoles();
	}

	@Test
	public void Given_Nothing_When_GetRoles_Then_CheckPerformanceForHugeVolume() {
		// Given
		// When
		List<Role> roles = new ArrayList<>();
		for (int i = 0; i < 100000; i++)
			roles.add(new Role("1", "ADMIN"));
		when(roleDao.getRoles()).thenReturn(roles);

		// Then
		List<Role> actual = roleService.getRoles();
		assertThat(actual.size(), is(100000));

		verify(roleDao, timeout(10).times(1)).getRoles();
	}

	@Test
	public void Given_Role_When_CreateRole_Then_Return1() {
		// Given
		Role role = new Role("1234", "ADMIN");

		// When
		when(roleDao.create(role)).thenReturn(1);

		// Then
		assertEquals(roleService.create(role).toString(), role.toString());
		verify(roleDao, times(1)).create(role);
	}

	@Test
	public void Given_InvalidRole_When_CreateRole_Then_ThrowException() {
		// Given
		Role role = null;

		// When
		when(roleDao.create(role)).thenThrow(NullPointerException.class);

		// Then
		Assertions.assertThrows(Exception.class, () -> {
			roleService.create(null);
		});
		verify(roleDao, times(1)).create(null);

	}

}
