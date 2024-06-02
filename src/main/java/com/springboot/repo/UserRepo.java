package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class UserRepo {
	
	@PersistenceContext
	private EntityManager eman;
	
	public User findByEmail(String email) {
		TypedQuery<User> query = eman.createQuery("SELECT log FROM User log WHERE log.email = :email",
				User.class);
		query.setParameter("email", email);
		List<User> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}
}
