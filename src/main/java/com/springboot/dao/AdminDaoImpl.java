package com.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springboot.bean.Admin;
import com.springboot.bean.User;
import com.springboot.repo.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	EntityManager eman;

	@Override
	public Admin adminLogin(String email, String password) {
		Query query1 = (Query) eman.createQuery("from Admin u where u.email =?1 and u.password=?2");
		query1.setParameter(1, email);
		query1.setParameter(2, password);
 
		Admin admin = (Admin) query1.getSingleResult();
		return admin;
	}
	
//	@Autowired
//	AdminRepo repo;
//	
//	@Override
//	public Admin adminLogin(String mail, String adminPassword) {
//		Query query1 = (Query) eman.createQuery("from Admin u where u.email =?1 and u.adminPassword=?2");
//		query1.setParameter(1, mail);
//		query1.setParameter(2, adminPassword);
// 
//		Admin admin = (Admin) query1.getSingleResult();
//		return admin;
// 
//	}

}
