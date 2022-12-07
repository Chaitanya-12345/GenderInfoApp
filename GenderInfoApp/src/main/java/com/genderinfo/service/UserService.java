package com.genderinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.genderinfo.entity.User;
import com.genderinfo.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public User insert(User u) {
		return repository.save(u);
	}

	public Optional<User> getById(int id) {
		return repository.findById(id) ;
	}

	public List<User> getAll() {
		return repository.findAll();
	}
	public String getByName(String name) {
		String out=repository.findByName(name);
		System.out.println(out);
		if(out==null) {
			return "user not available";
		}
		return out;
	}

	

}
