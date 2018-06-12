package com.easynotes.service;

import java.util.List;

import com.easynotes.dto.UserInDto;
import com.easynotes.dto.UserOutDto;
import com.easynotes.model.UserEntity;

public interface UserService
{
	public UserOutDto createUser(UserInDto userInDto);

	public UserOutDto updateUser(UserInDto userInDto, Long id);

	public void deleteUser(Long id);

	public List<UserEntity> findAll();
}
