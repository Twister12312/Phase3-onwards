package com.mphasis.mAadhar.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User implements Serializable {
/***************************************Instance variables***************************************/	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Uid;
	@Column
    private String name;
	
	@Column(nullable=false)
	private String gender;
	
	@Column(unique=true,nullable=false)
	private String mail;
	
	@Column(nullable=false)
	private String passwd;
	

	@Column(nullable=false)
	private Date DOB;
	
	@Column(length=60)
	private String address;
	

	@Column(nullable=false)
	private Long pincode;
	
	@Column
	private String aadharno;
	
	


	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_userlog", joinColumns= {@JoinColumn(name="Uid")}, inverseJoinColumns= {@JoinColumn(name="Usrid")})
	private Set<UserLog>requests=new HashSet<UserLog>();



/*******************************GETTERS AND SETTERS*********************************************/

	public Long getUid() {
		return Uid;
	}

	public void setUid(Long uid) {
		Uid = uid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getmail() {
		return mail;
	}

	public void setmail(String mail) {
		this.mail = mail;
	}
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	

	public Set<UserLog> getRequests() {
		return requests;
	}

	public void setRequests(Set<UserLog> requests) {
		this.requests = requests;
	}
	
	public void addRequest(UserLog request) {
		this.requests.add(request);
	}
	
	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
/*************************************Constructors*****************************************/
	public User(String name, String mail, Date dOB, String address, Long pincode, String aadharno) {
		super();
		this.name = name;
		this.mail = mail;
		DOB = dOB;
		this.address = address;
		this.pincode = pincode;
		this.aadharno=aadharno;	}
	
	
public User() {
	super();
}
	

}
