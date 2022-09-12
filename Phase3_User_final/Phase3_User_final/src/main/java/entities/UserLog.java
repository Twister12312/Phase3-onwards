package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserLog")
public class UserLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ul_id;
	
	@Column(name = "user",length=50)
	private String user;
	
	@ManyToMany(mappedBy="entries")
	private Set<Quiz> quiz=new HashSet<Quiz>();
	
	public UserLog() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Column(name = "score")
	private int score;

	public UserLog(String user,int num) {
		super();
		this.user = user;
		this.score=num;
		//this.score = score;
	}
	
	
	
}
