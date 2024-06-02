package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Admin;
import com.springboot.bean.User;
import com.springboot.dao.AdminDao;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	AdminDao dao;
	
	@GetMapping("/loginAdmin/{email}/{password}")
	public boolean login(@PathVariable("email") String email,@PathVariable ("password") String password) {

		try {
			dao.adminLogin(email,password);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	}
	
