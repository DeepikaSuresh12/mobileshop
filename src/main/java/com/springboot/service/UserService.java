package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.bean.User;

public interface UserService {


	 List<User> getallUsers();
	 List<User> getUserById(int id);
	 Optional<User> getUserByEmailId(String email);
	 ResponseEntity<?> login(String email, String password);
}
