package entities;


public class User {

	
	private long u_id;
	
	private String pass;
	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}


	private String user;
	
	
	public long getU_id() {
		return u_id;
	}



	public User(String user) {
		super();
		this.user = user;
	}



	public void setU_id(long u_id) {
		this.u_id = u_id;
	}


	public User() {
		super();
	}



	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}

}
