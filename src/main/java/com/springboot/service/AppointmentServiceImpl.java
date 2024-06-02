package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bean.Appointment;
import com.springboot.bean.RepairShop;
import com.springboot.dao.AppointmentDao;
import com.springboot.repo.AppointmentRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDao dao;

	@Override
	public void addAppointment(Appointment appointment) {
		dao.addAppointment(appointment);
		
	}

	@Override
	public List<Appointment> getallAppointments() {
		return dao.getallAppointments();
				
		
	}

	@Override
	public Appointment getAppointmentById(long appointmentId) {
		// TODO Auto-generated method stub
		return dao.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentHistory(int id) {
		// TODO Auto-generated method stub
		return dao.getAppointmentHistory(id);
	}

	@Transactional
	@Override
	public ResponseEntity<?> updateAppointment(long appointmentId, Appointment updatedService, long scId) {
	    return dao.updateAppointment(appointmentId, updatedService, scId);
	}

	@Override
	public Appointment getAppointmentId(Long id) {
		// TODO Auto-generated method stub
		return dao.getAppointmentId(id);
	}

	@Override
	public List<Appointment> getByShopIds(Long id) {
		// TODO Auto-generated method stub
		return dao.getByShopIds(id);
	}
	
}
