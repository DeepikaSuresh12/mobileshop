package com.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;
@Repository
public interface AppointmentService {

	public void addAppointment(Appointment appointment);
	 
	 List<Appointment> getallAppointments();
	 Appointment getAppointmentById(long appointmentId);
	 List<Appointment> getAppointmentHistory(int id);
	 ResponseEntity<?> updateAppointment(long appointmentId, Appointment updatedService,long scId);
	 Appointment getAppointmentId(Long id);
    List<Appointment> getByShopIds(Long id);
}
