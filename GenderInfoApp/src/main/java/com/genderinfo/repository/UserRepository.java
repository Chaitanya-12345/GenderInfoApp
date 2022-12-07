package com.genderinfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.genderinfo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	@Query("select user.gender from User user where user.name=?1")
	public String findByName(String name);
	
	}