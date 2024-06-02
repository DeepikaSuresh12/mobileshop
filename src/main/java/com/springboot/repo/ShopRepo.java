package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;
import com.springboot.bean.RepairShop;
import com.springboot.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ShopRepo {


	@PersistenceContext
	private EntityManager eman;
	
	
	
	@Transactional
	public void saveShop(RepairShop shop) {
		eman.persist(shop);
	}
	
	
	public RepairShop findByEmail(String email) {
		TypedQuery<RepairShop> query = eman.createQuery("SELECT log FROM RepairShop log WHERE log.email = :email",
				RepairShop.class);
		query.setParameter("email", email);
		List<RepairShop> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}
}
