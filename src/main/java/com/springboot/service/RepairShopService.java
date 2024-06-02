package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.bean.RepairShop;

public interface RepairShopService {

	void addRepairShop(RepairShop repairShop);
    List<RepairShop> getallRepairShops();
    List<RepairShop> getShopById(int id);
    Optional<RepairShop> getShopByEmailId(String email);
    ResponseEntity<?> login(String email, String password);
    List<Long> getShopIdlist();
    Optional<RepairShop> findById(long id);
    Object updateRating(long shopId, double newRating, String review); 
}
