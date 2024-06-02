package com.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Appointment;
import com.springboot.bean.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.springboot.dao.AppointmentDaoImpl;
import com.springboot.service.AppointmentServiceImpl;



@RestController
@CrossOrigin("*")
public class AppointmentController {
 


@Autowired
	AppointmentServiceImpl dao;
	
	@PostMapping("/CreateAppointment")
    public String addAppointment(@RequestBody Appointment appointment) {
        String msg="";
        try {
            dao.addAppointment(appointment);
            msg="Appointment Details Saved";
        }catch(Exception e) {
            msg="Appointment Details not saved";
        }
        return msg;
    }
	@GetMapping("/getAllAppointment")
    public List<Appointment> getallAppointment() {
        try {
            return dao.getallAppointments();
        } catch (Exception e) {
            e.printStackTrace();
        }
  return null;
    }
	
	@GetMapping("/getAppointmentHistory/{id}")
	public List<Appointment> getAppointmentHistory(@PathVariable int id){
	    try {
	        return dao.getAppointmentHistory(id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}	
		
//	@PutMapping("/update/{id}")
//    public ResponseEntity<?> updateService(@PathVariable("id") long appointmentId, @RequestBody Appointment updatedAppointment,  @RequestParam long shopId) {
//        return dao.updateAppointment(appointmentId, updatedAppointment, shopId);
//    }
	
	@PutMapping("/update/{appointmentId}")
	public ResponseEntity<?> updateService(@PathVariable("appointmentId") long appointmentId, @RequestBody Appointment updateappoAppointment, @RequestParam long shopId){
		return dao.updateAppointment(appointmentId, updateappoAppointment, shopId);
	}

	
//	@DeleteMapping("/delete/{id}")
//	public String deleteAppointment(@PathVariable Long id) {
//	     String msg = "";
//	     try {
//	         dao.deleteAppointment(id);
//	         msg = " Details Deleted";
//	     } catch (Exception e) {
//	         msg = " Details not Deleted";
//	     }
//	     return msg;
//	}
//	
	@GetMapping("/getappointmentbysid/{id}")
	public List<Appointment> getByAppointmentId(@PathVariable long id){
		 try {
			return dao.getByShopIds(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	}


