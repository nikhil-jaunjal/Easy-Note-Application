package com.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.dto.UserInDto;
import com.easynotes.dto.UserOutDto;
import com.easynotes.model.UserEntity;
import com.easynotes.service.UserService;
@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController
{
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserEntity> findAll(){
		return userService.findAll();
	}
	
	@PostMapping
	public UserOutDto save(@RequestBody UserInDto userInDto)
	{
		return userService.createUser(userInDto);
	}

	@DeleteMapping
	public void delete(@RequestParam("id") Long id)
	{
		userService.deleteUser(id);
	}

	@PutMapping
	public UserOutDto update(@RequestBody UserInDto userInDto, @RequestParam("id") Long id)
	{
		return userService.updateUser(userInDto, id);
	}
}
