package com.example2._Feedback;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id", updatable = false, nullable = false)
	    private int id;
	   
	 @Column(length=50)
	    private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected Feedback() {
		super();
	}

	public Feedback(String description) {
		super();
		this.description = description;
	}
	
	
}
