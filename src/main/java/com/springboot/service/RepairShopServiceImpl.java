package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bean.RepairShop;
import com.springboot.dao.RepairShopDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RepairShopServiceImpl implements RepairShopService {
	
	@Autowired
	RepairShopDao dao;

	@Override
	public void addRepairShop(RepairShop repairShop) {
		// TODO Auto-generated method stub
		dao.addRepairShop(repairShop);
		
	}

	@Override
	public List<RepairShop> getallRepairShops() {
		// TODO Auto-generated method stub
		return dao.getallRepairShops();
	}

	@Override
	public List<RepairShop> getShopById(int id) {
		// TODO Auto-generated method stub
		return dao.getShopById(id);
	}

	@Override
	public Optional<RepairShop> getShopByEmailId(String email) {
		// TODO Auto-generated method stub
		return dao.getShopByEmailId(email);
	}

	@Override
	public ResponseEntity<?> login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public List<Long> getShopIdlist() {
		// TODO Auto-generated method stub
		return dao.getShopIdlist();
	}

	@Override
	public Optional<RepairShop> findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Object updateRating(long shopId, double newRating, String review) {
		
		return dao.updateRating(shopId, newRating, review);
		
	}

}
