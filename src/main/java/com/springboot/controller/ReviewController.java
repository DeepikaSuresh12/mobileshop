package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Appointment;
import com.springboot.bean.RepairShop;
import com.springboot.bean.Review;
import com.springboot.bean.User;
import com.springboot.dao.ReviewDaoImpl;
import com.springboot.service.AppointmentServiceImpl;

@RestController
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	ReviewDaoImpl dao;
	
	@PostMapping("/createreview")
    public String addReview(@RequestBody Review review,@RequestParam long userId,@RequestParam long shopId) {
        String msg="";
        try {
            dao.addReview(review, userId, shopId);
            msg="Review Details Saved";
        }catch(Exception e) {
            msg="Review Details not saved";
        }
        return msg;
    }
	
	@GetMapping("/getallreview")
    public List<Review> getAllReview() {
        try {
            return dao.getAllReview();
        } catch (Exception e) {
            e.printStackTrace();
        }
  return null;
    }
}
