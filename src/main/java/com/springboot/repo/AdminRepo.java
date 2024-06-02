package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Admin;
import com.springboot.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class AdminRepo {

	    @PersistenceContext
		private EntityManager eman;
		
		public Admin findByEmail(String email) {
			TypedQuery<Admin> query = eman.createQuery("SELECT log FROM Admin log WHERE log.email = :email",
					Admin.class);
			query.setParameter("email", email);
			List<Admin> results = query.getResultList();
			return results.isEmpty() ? null : results.get(0);
		}

}
