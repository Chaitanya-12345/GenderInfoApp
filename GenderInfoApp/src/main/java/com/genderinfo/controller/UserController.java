package com.genderinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.genderinfo.entity.User;
import com.genderinfo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("insert")
	public User insert(@RequestBody User u) {
		return service.insert(u);
	}

	@Scheduled(fixedRate = 50000)
	@GetMapping("getAll")
	public List<User> getAll() {
		List<User> users = service.getAll();
		for (User user : users) {
			System.out.println(user);
		}
		return users;
	}

	@GetMapping("getById/{id}")
	public Optional<User> getById(@PathVariable("id") int id) {
		return service.getById(id);
	}

	@GetMapping("getByName")
	public String getByName(@RequestParam(value = "name") String name) {
		return service.getByName(name);
	}
}
