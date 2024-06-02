package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;
import com.springboot.dao.UserDaoImpl;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserDaoImpl dao;

	@PostMapping("/CreateUser")
	public String addcourse(@RequestBody User user) {
		String msg = "";
		try {
			dao.addUser(user);
			msg = "User Details Saved";
		} catch (Exception e) {
			msg = "User Details not saved";
		}
		return msg;
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		try {
			return dao.getallUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@PutMapping("/updateUser")
	public String updateUserInfo(@RequestBody User user) {
		String msg = "";
		try {
			dao.updateUserInfo(user);
			msg = "User Details Updated";
		} catch (Exception e) {
			msg = "User Details not Updated";
		}
		return msg;
	}

	@GetMapping("/getUserById/{id}")
	public List<User> getUser(@PathVariable int id) {
		try {
			return dao.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@DeleteMapping("/DeleteUser/{id}")
	public String deleteUserInfo(@PathVariable int id) {
		String msg = "";
		try {
			dao.deleteUser(id);
			msg = "User Details Deleted";
		} catch (Exception e) {
			msg = "User Details not Deleted";
		}
		return msg;
	}

	@PostMapping("/registerUser")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
			// Validate input data (you can add more validation logic)
			if (user.getEmail() == null || user.getPassword() == null || user.getPhoneNo() == null
					|| user.getUserAddress() == null || user.getUserName() == null) {
			}

			// Save admin to the database
			dao.addUser(user);

			return ResponseEntity.ok("User registered successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during registration: " + e.getMessage());
		}
	}

	@PostMapping("/loginUser")
	public ResponseEntity<?> login(@RequestBody User user) {
		return dao.login(user.getEmail(), user.getPassword());
	}
}