package com.springboot.bean;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class RepairShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopId;

	private String name;
	private String address;
	private String contactNumber;
	private String operatingHours;
	private String specialities;
	private String email;	
	private String password;
    private double rating;
    private String review;
    private String status;
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RepairShop() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public String getReview() {
		return review;
	}
	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	
   public void setReview(String review) {
		this.review = review;
	}

	

	public RepairShop(long shopId, String name, String address, String contactNumber, String operatingHours,
			String specialities, String email, String password, double rating) {
		super();
		this.shopId = shopId;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.operatingHours = operatingHours;
		this.specialities = specialities;
		this.email = email;
		this.password = password;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RepairShop [shopId=" + shopId + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + ", operatingHours=" + operatingHours + ", specialities=" + specialities + ", email="
				+ email + ", password=" + password + ", rating=" + rating + "]";
	}

	

}
