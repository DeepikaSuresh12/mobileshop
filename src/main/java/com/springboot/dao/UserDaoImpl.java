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

import com.springboot.bean.User;
import com.springboot.repo.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
 
	private EntityManager eman;
	
	@Autowired
	private UserRepo userRepo;
	 
	public UserDaoImpl() {
		super();
	}
	
	@Autowired
	public UserDaoImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addUser(User user) {
        try {
            eman.persist(user);
        }catch(Exception e) {
            e.printStackTrace();
        }
	}
	@Override
    public List<User> getallUsers() {
        List<User> user = new ArrayList<>();
        try {
        	user = eman.createQuery("from User E").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
	public void updateUserInfo(User user) {
        try {
            eman.createQuery("UPDATE User E SET , E.userName= :userName, E.userAddress= :userAddress,  E.email= :email, E.password = :password, E.phoneNo= :phoneNo WHERE E.userId= :userId")
            .setParameter("userId", user.getUserId()).setParameter("name", user.getUserName()).setParameter("userAddress", user.getUserAddress())
            .setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).setParameter("phoneNo", user.getPhoneNo())
            .executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@SuppressWarnings("unchecked")
	@Override
	    public List<User> getUserById(int Id) {
	        List<User> user = new ArrayList<>();
	        try {
	        	user = eman.createQuery("from User E where E.id = :id").setParameter("id", Id).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
 
    public void deleteUser(int id) {
        List<User> userById = getUserById(id);
        eman.remove(userById.get(0));
    }
    
    @Override
    public Optional<User> getUserByEmailId(String email) {
		TypedQuery<User> query = eman.createQuery("SELECT log FROM User log WHERE log.email = :email",
				User.class);
		query.setParameter("email", email);
		List<User> results = query.getResultList();
		return results.isEmpty() ? null : Optional.of(results.get(0));
	}
    
    @Override
	public ResponseEntity<?> login(String email, String password) {
		User login = userRepo.findByEmail(email);
		
		if (login.getEmail().isEmpty()) {
			return ResponseEntity.badRequest().body("Email Not present");
		}

		if (!password.equals(login.getPassword())) {
			return ResponseEntity.badRequest().body("Invalid email or password");
		}
	
		
		Map<String, Object> responseData = new HashMap<>();
        responseData.put("userId", login.getUserId());
		
		return ResponseEntity.ok(responseData);
	}
	
    public User findByEmail(String email) {
		TypedQuery<User> query = eman.createQuery("SELECT log FROM User log WHERE log.email = :email",
				User.class);
		query.setParameter("email", email);
		List<User> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}

}


