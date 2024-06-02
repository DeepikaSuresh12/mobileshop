package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;
import com.springboot.bean.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ReviewRepo {

	@PersistenceContext
	private EntityManager eman;

	@Transactional
	public void saveReview(Review review) {
		eman.persist(review);
	}
	
	public List<Review> getAllReview(){
		TypedQuery<Review> query = eman.createQuery ("From Review", Review.class);
		return query.getResultList();
	}
}
