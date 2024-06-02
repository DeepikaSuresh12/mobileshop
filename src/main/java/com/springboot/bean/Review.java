package com.springboot.bean;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;

	private String review;
	
	@ManyToOne
	@JoinColumn(name="shop_id")
	private RepairShop shop;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public RepairShop getShop() {
		return shop;
	}

	public void setShop(RepairShop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", review=" + review + ", shop=" + shop + ", user=" + user + "]";
	}
	
	
}
