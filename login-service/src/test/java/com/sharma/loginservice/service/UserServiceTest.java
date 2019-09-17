package com.sharma.loginservice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

import com.sharma.loginservice.customexceptions.CreationException;
import com.sharma.loginservice.dao.UserDAO;
import com.sharma.loginservice.model.UserEntity;
import com.sharma.loginservice.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@DisplayName("Test for User Service")
public class UserServiceTest {

	@Mock
	private UserDAO userDao;

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Test
	public void Given_UserEntity_When_Register_Then_Returns1() {
		// Given
		UserEntity userEntity = new UserEntity("1", "srivatsa", "1234");

		// When
		when(userDao.create(userEntity)).thenReturn(1);

		// Then
		assertThat(userDao.create(userEntity), is(1));
		verify(userDao, times(1)).create(userEntity);
	}

	@Test
	public void Given_InvalidUser_When_Register_Then_ThrowCreationException() {
		// Given
		UserEntity userEntity = null;

		// When
		when(userDao.create(userEntity)).thenThrow(CreationException.class);

		// Then
		Assertions.assertThrows(CreationException.class, () -> {
			userDao.create(userEntity);
		});
		verify(userDao, times(1)).create(userEntity);
	}

}
