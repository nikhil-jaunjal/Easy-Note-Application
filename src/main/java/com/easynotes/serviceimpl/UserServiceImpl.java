package com.easynotes.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easynotes.dao.UserDAO;
import com.easynotes.dto.UserInDto;
import com.easynotes.dto.UserOutDto;
import com.easynotes.enums.ErrorCode;
import com.easynotes.exception.BadRequestException;
import com.easynotes.exception.DataNotFoundException;
import com.easynotes.messages.ErrorMessage;
import com.easynotes.model.UserEntity;
import com.easynotes.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDAO userRepo;
	@Autowired
	private Mapper mapper;

	@Override
	public UserOutDto createUser(UserInDto userInDto)
	{
		UserEntity userEntity = userRepo.findByEmail(userInDto.getEmail());
		if (Objects.nonNull(userEntity))
		{
			throw new BadRequestException(new ErrorMessage(ErrorCode.BAD_REQUEST));
		}
		userEntity = mapper.map(userInDto, UserEntity.class);
		userEntity = userRepo.save(userEntity);
		return mapper.map(userEntity, UserOutDto.class);
	}

	@Override
	public UserOutDto updateUser(UserInDto userInDto, Long id)
	{
		UserEntity userEntity = userRepo.findOne(id);
		if (Objects.isNull(userEntity))
		{
			throw new BadRequestException(new ErrorMessage(ErrorCode.BAD_REQUEST));
		}
		userEntity = mapper.map(userInDto, UserEntity.class);
		userEntity.setUserId(id);
		userRepo.save(userEntity);
		userEntity = userRepo.findOne(id);
		return mapper.map(userEntity, UserOutDto.class);
	}

	@Override
	public void deleteUser(Long id)
	{
		validateAndGetUserEntity(id);
		userRepo.delete(id);
	}

	private UserEntity validateAndGetUserEntity(Long id)
	{
		UserEntity userEntity = userRepo.findOne(id);
		if (Objects.isNull(userEntity))
		{
			throw new DataNotFoundException(new ErrorMessage(ErrorCode.NOT_FOUND));
		}
		return userEntity;
	}

	@Override
	public List<UserEntity> findAll()
	{
		return userRepo.findAll();
	}

}
