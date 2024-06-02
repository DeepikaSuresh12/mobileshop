package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;
import com.springboot.bean.RepairShop;
import com.springboot.bean.User;
import com.springboot.repo.AppointmentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Component
public class AppointmentDaoImpl implements AppointmentDao {
 
	@Autowired
	private EntityManager eman;
	 
	@Autowired
	AppointmentRepo repo;


	@Override
    public void addAppointment(Appointment appointment) {
        repo.saveAppointment(appointment);
	}
    
    @Override
    public ResponseEntity<?> updateAppointment(long appointmentId, Appointment updatedAppointment, long shopId) {
    	Appointment existingRequest =repo.getAppointmentById(appointmentId);
    	System.out.println(shopId);
        if (existingRequest == null) {
            return ResponseEntity.badRequest().body("Request not found");
        }
        
        // Update
        existingRequest.setStatus(updatedAppointment.getStatus());
        
        RepairShop sc=eman.find(RepairShop.class, shopId);
        existingRequest.setShop(sc);
 
        // Save the update
        repo.saveAppointment(existingRequest);
        return ResponseEntity.ok("Details updated successfully");
    }

	@Override
	public List<Appointment> getallAppointments() {
		return repo.getAllAppointment();
	}

	@Override
	public Appointment getAppointmentById(long appointmentId) {
		return repo.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentHistory(int id) {
		return repo.getAppointmentHistory(id);
	}
	
	@Override
	public Appointment getAppointmentId(Long id) {
		return eman.find(Appointment.class, id);
		
	}
	public void deleteAppointment(Long id) {
	     Appointment appointmentById = getAppointmentById(id);
	     eman.remove(appointmentById);
	 }
   
	public List<Appointment> getByShopIds(Long id) {
		try {
			return eman.createQuery("FROM Appointment where shop.shopId =:shopId", Appointment.class)
			.setParameter("shopId", id).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
}

