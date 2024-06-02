package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AppointmentRepo {
	
	@PersistenceContext
	private EntityManager eman;

	@Transactional
	public void saveAppointment(Appointment appointment) {
		eman.persist(appointment);
	}
	
	public List<Appointment> getAllAppointment(){
		TypedQuery<Appointment> query = eman.createQuery ("From Appointment", Appointment.class);
		return query.getResultList();
	}
	
	public Appointment getAppointmentById(long Id) {
		return eman.find(Appointment.class, Id);
	}
	
	
	public void deleteAppointment(long id) {
		Appointment app=getAppointmentById(id);
		if (app != null) {
			eman.remove(app);
		}
	}
	
	
	public List<Appointment> getAppointmentHistory(long id){
		TypedQuery<Appointment> app=eman.createQuery("from Appointment E where user.userId = :id", Appointment.class);
				app.setParameter("id", id).getResultList();
				return app.getResultList();
	}
}
