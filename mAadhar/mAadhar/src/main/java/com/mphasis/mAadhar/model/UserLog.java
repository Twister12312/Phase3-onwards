package com.mphasis.mAadhar.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class UserLog implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Usrid;
	
	@Column(nullable=false)
	private boolean newappln;
	
	@Column(nullable=false)
	private boolean update;
	
	@Column(nullable=false)
	private boolean duplicate;
	
     @Column(nullable=false)
	 private boolean status;

/******************************Getters and setters*****************************************/
	public Long getUsrid() {
		return Usrid;
	}

	public void setUsrid(Long usrid) {
		Usrid = usrid;
	}
	
	public boolean isNewappln() {
		return newappln;
	}

	public void setNewappln(boolean newappln) {
		this.newappln = newappln;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isDuplicate() {
		return duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

/**************************************Constructor*******************************************/
	public UserLog(boolean newappln, boolean update, boolean duplicate,boolean status) {
		super();
		this.newappln = newappln;
		this.update = update;
		this.duplicate = duplicate;
		this.status=status;
	}

	public UserLog() {
		super();
	}
	

}
