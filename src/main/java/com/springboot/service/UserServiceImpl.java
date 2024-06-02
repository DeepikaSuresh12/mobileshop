package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bean.User;
import com.springboot.dao.UserDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;

	@Override
	public List<User> getallUsers() {
		// TODO Auto-generated method stub
		return dao.getallUsers();
	}

	@Override
	public List<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	public Optional<User> getUserByEmailId(String email) {
		// TODO Auto-generated method stub
		return dao.getUserByEmailId(email);
	}

	@Override
	public ResponseEntity<?> login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

}
