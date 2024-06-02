package com.springboot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springboot.bean.RepairShop;
import com.springboot.bean.User;
import com.springboot.repo.ShopRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepairShopDaoImpl implements RepairShopDao {
 
	private EntityManager eman;
	 
    @Autowired
    private ShopRepo shopRepo;
 
    @Autowired
    public RepairShopDaoImpl(EntityManager entity) {
        this.eman = entity;
    }
 
    @Override
    public void addRepairShop(RepairShop shop) {
        try {
            eman.persist(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public List<RepairShop> getallRepairShops() {
        List<RepairShop> shops = null;
        try {
            shops = eman.createQuery("from RepairShop").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shops;
    }
 
    @Override
    public List<RepairShop> getShopById(long id) {
        List<RepairShop> shops = null;
        try {
            shops = eman.createQuery("from RepairShop E where E.shopId = :id")
                        .setParameter("id", id).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shops;
    }
 
    @Override
    public Optional<RepairShop> getShopByEmailId(String email) {
        TypedQuery<RepairShop> query = eman.createQuery(
"SELECT log FROM RepairShop log WHERE log.email = :email",
            RepairShop.class
        );
        query.setParameter("email", email);
        List<RepairShop> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
 
    @Override
    public ResponseEntity<?> login(String email, String password) {
        RepairShop login = shopRepo.findByEmail(email);
        if (login == null) {
            return ResponseEntity.badRequest().body("Email not found");
        }
        if (!password.equals(login.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
        return ResponseEntity.ok(Map.of("shopId", login.getShopId()));
    }
 
    @Override
    public List<Long> getShopIdlist() {
        Query q = eman.createQuery("SELECT c.shopId FROM RepairShop c");
        return q.getResultList();
    }
 
    @Override
    public Optional<RepairShop> findById(long id) {
        return Optional.ofNullable(eman.find(RepairShop.class, id));
    }
 
    @Override
    public Object updateRating(long shopId, double newRating, String review) {
        try {
            RepairShop shop = eman.find(RepairShop.class, shopId);
            
            if (shop != null) {
            	if (shop.getRating() == 0) {
					shop.setRating(newRating);
					shop.setReview(review);
					eman.merge(shop);
				}else {
					double currentRating = shop.getRating();
	            	currentRating = (newRating+currentRating)/2;
	                shop.setRating(currentRating);
	                shop.setReview(review);
	                eman.merge(shop);
				} 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return newRating;
    }  
    
    @Override
	public ResponseEntity<?> updateShop(long shopId, RepairShop updatedShop) {
		RepairShop existingShop = eman.find(RepairShop.class, shopId);
				
        if (existingShop == null) {
            return ResponseEntity.badRequest().body("Shop not found");
        }
        
        // Update
        existingShop.setStatus(updatedShop.getStatus());
//        existingStudent.setAdmin(updatedStudent.getAdmin());
 
        // Save the update
        eman.persist(existingShop);
        return ResponseEntity.ok("Details updated successfully");
	}
    
  @Override
    public void deleteShop(Long id) {
        RepairShop applicationById = getShopById(id);
        eman.remove(applicationById);
    }
	
	public RepairShop getShopById(Long id) {
		return eman.find(RepairShop.class, id);
	}

	@Override
	public RepairShop getShopId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
