package com.easynotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easynotes.model.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity, Long>
{
	UserEntity findByEmail(String email);

}
