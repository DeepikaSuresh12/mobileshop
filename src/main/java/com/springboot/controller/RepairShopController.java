package com.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.RepairShop;
import com.springboot.bean.User;
import com.springboot.dao.RepairShopDaoImpl;
import com.springboot.dao.UserDaoImpl;

@RestController
@CrossOrigin("*")
public class RepairShopController {

	@Autowired
	RepairShopDaoImpl dao;

	@Autowired
	JavaMailSender emailsender;
	
	@PostMapping("/CreateRepairShop")
	public String addRepairShop(@RequestBody RepairShop repairShop) {
		
		System.out.println(repairShop);
		String msg = "";
		try {
			dao.addRepairShop(repairShop);
			msg = "RepairShop Details Saved";
		} catch (Exception e) {
			msg = "RepairShop Details not saved";
		}
		return msg;
	}

	@GetMapping("/getallrepairshop")
	public List<RepairShop> getAllRepairShop() {
		try {
			return dao.getallRepairShops();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

//	@PutMapping("/updateRepairShop")
//	public String updateRepairShopInfo(@RequestBody RepairShop repairShop) {
//		String msg = "";
//		try {
//			dao.updateRepairShopInfo(repairShop);
//			msg = "RepairShop Details Updated";
//		} catch (Exception e) {
//			msg = "RepairShop Details not Updated";
//		}
//		return msg;
//	}

//	@GetMapping("/getShopById/{id}")
//	public List<RepairShop> getUser(@PathVariable int id) {
//		try {
//			return dao.getShopById(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}

	@PostMapping("/registerRepairShop")
	public ResponseEntity<String> register(@RequestBody RepairShop repairShop) {
		try {
			// Validate input data (you can add more validation logic)
			if (repairShop.getName() == null || repairShop.getAddress() == null || repairShop.getContactNumber() == null
					|| repairShop.getOperatingHours() == null || repairShop.getSpecialities() == null) {
			}

			// Save admin to the database
			dao.addRepairShop(repairShop);

			return ResponseEntity.ok("RepairShop registered successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during registration: " + e.getMessage());
		}
	}

	@PostMapping("/loginRepairShop")
	public ResponseEntity<?> login(@RequestBody RepairShop repairShop) {
		return dao.login(repairShop.getEmail(), repairShop.getPassword());
	}

	@GetMapping("/GetShopIds")
	public List<Long> getShopIdlists() {
		try {
			return dao.getShopIdlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}
	
	 @PutMapping("/updateRating/{shopId}")
	    public ResponseEntity<String> updateRating(
	            @PathVariable long shopId, @RequestParam double rating ,@RequestParam String review) {
	        try {
	        	
	        	System.out.println(shopId +" "+ rating +review);
	            dao.updateRating(shopId, rating ,review);
	            return ResponseEntity.ok("Rating and Review updated successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Error updating rating and review: " + e.getMessage());
	        }
	    }
	 
	 @PutMapping("/updateshopstatus/{id}")
	 public ResponseEntity<?> updateShop(@PathVariable("id") Long id,
	                                        @RequestBody RepairShop shop) {
	      return dao.updateShop(id, shop);
	 } 
	 
	 @PostMapping("/sendEmail/{id}")
	 public ResponseEntity<?> sendShopEmail(@PathVariable("id") Long id) {
	      Optional<RepairShop> shopOptional = Optional.ofNullable(dao.getShopById(id));
	      if (!shopOptional.isPresent()) {
	          return ResponseEntity.badRequest().body("Shop not found");
	      }
	      RepairShop shop = shopOptional.get();
	  
	      SimpleMailMessage message = new SimpleMailMessage();
	      message.setFrom("no.reply.autorepair@gmail.com");
	      message.setTo(shop.getEmail());
	      message.setSubject("Registration Successful...!!!");
	      message.setText("Your Registration has been approved " + shop.getName()+" "+"You can Login through the following credentials"+" "+ "Username - "+" "+shop.getEmail()+" "+ "Password - "+" "+shop.getPassword());
	  
	      emailsender.send(message);
	  
	      return ResponseEntity.ok().body("Email sent to " + shop.getEmail());
	 }
	 
	 @DeleteMapping("/deleteshop/{id}")
	 public ResponseEntity<?> deleteShop(@PathVariable Long id) {
	      try {
	          dao.deleteShop(id);
	          return ResponseEntity.ok().build();
	      } catch (Exception e) {
	          // Handle the exception appropriately
	          return ResponseEntity.badRequest().body("Error deleting application: " + e.getMessage());
	      }
	 }
	 }
	
	


