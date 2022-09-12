package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
     public long getU_id() {
		return u_id;
	}


	public void setU_id(long u_id) {
		this.u_id = u_id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}

	public User() {
		super();
	}



	
	public User(String user) {
		super();
		this.user = user;
	}



	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long u_id;
	
	@Column(name = "user",length=50)
	 private String user;
	
	@Column(name = "pass",length=50)
	private String pass;
	
}
