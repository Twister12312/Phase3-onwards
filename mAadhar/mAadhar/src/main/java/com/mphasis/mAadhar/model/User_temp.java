package com.mphasis.mAadhar.model;

import java.sql.Date;

import javax.persistence.Column;

public class User_temp {
	private Long Uid;
	
    public User_temp() {
		super();
	}



	public User_temp(Long uid, String name, String gender, String mail, Date dOB, String address, Long pincode) {
		super();
		Uid = uid;
		this.name = name;
		this.gender = gender;
		this.mail = mail;
		DOB = dOB;
		this.address = address;
		this.pincode = pincode;
	}



	private String name;
	
	
	private String gender;
	
	
	private String mail;
	
	
	private Date DOB;
	
	
	public Long getUid() {
		return Uid;
	}



	public void setUid(Long uid) {
		Uid = uid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public Date getDOB() {
		return DOB;
	}



	public void setDOB(Date dOB) {
		DOB = dOB;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Long getPincode() {
		return pincode;
	}



	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}



	private String address;
	

	
	private Long pincode;
}
