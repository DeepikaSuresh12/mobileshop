package com.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.bean.Appointment;
import com.springboot.bean.User;

public interface AppointmentDao {

	public void addAppointment(Appointment appointment);
	 
	 List<Appointment> getallAppointments();
	 Appointment getAppointmentById(long appointmentId);
	 List<Appointment> getAppointmentHistory(int id);
	 ResponseEntity<?> updateAppointment(long appointmentId, Appointment updatedService,long scId);
	 Appointment getAppointmentId(Long id);
     List<Appointment> getByShopIds(Long id);
     
}
 