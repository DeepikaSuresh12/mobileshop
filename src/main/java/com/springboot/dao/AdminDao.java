package com.springboot.dao;

import org.springframework.http.ResponseEntity;

import com.springboot.bean.Admin;

public interface AdminDao {


//	ResponseEntity<?> login(String email, String password);

	public Admin adminLogin(String email, String adminPassword);


}
