package com.springboot.dao;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.bean.RepairShop;
import com.springboot.bean.Review;
import com.springboot.bean.User;
import com.springboot.repo.AppointmentRepo;
import com.springboot.repo.ReviewRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Component
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private EntityManager eman;
	 
	@Autowired
	private ReviewRepo repo;
	
	@Override
	public void addReview(Review review, long userId, long shopId) {
		
		User user=eman.find(User.class, userId);
		review.setUser(user);
		
		RepairShop rs=eman.find(RepairShop.class, shopId);
		review.setShop(rs);
		
		repo.saveReview(review);	
	}

	@Override
	public List<Review> getAllReview1() {
		return repo.getAllReview();
	}
	
	@Transactional
	public void saveReview(Review review) {
		eman.persist(review);
	}
	
	public List<Review> getAllReview(){
		TypedQuery<Review> query = eman.createQuery ("From Review", Review.class);
		return query.getResultList();
	}

}
