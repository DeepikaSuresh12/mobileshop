package com.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.bean.RepairShop;
import com.springboot.bean.User;

public interface RepairShopDao {

	void addRepairShop(RepairShop repairShop);
    List<RepairShop> getallRepairShops();
    List<RepairShop> getShopById(long id);
    Optional<RepairShop> getShopByEmailId(String email);
    ResponseEntity<?> login(String email, String password);
    List<Long> getShopIdlist();
    Optional<RepairShop> findById(long id);
    Object updateRating(long shopId, double newRating, String review); 
    
    RepairShop getShopId(Long id);
	
	 ResponseEntity<?> updateShop(long id,RepairShop updatedShop);
	
	 void deleteShop(Long id);
	
}