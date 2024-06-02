package com.springboot.dao;

import java.util.List;

import com.springboot.bean.Appointment;
import com.springboot.bean.RepairShop;
import com.springboot.bean.Review;
import com.springboot.bean.User;

public interface ReviewDao {

	public void addReview(Review review, long userId, long shopId);
	 
	 List<Review> getAllReview();

	List<Review> getAllReview1();

	
}
