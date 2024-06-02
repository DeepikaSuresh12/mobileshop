package com.springboot.bean;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userAddress;
	private String email;
	private String password;
	private String phoneNo;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int userId, String userName, String userAddress, String email, String password, String phoneNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", email=" + email
				+ ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}

	
}
