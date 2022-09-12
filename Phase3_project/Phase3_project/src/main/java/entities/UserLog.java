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

	@Column(name = "score")
	private int score;

	public UserLog(String user, int score) {
		super();
		this.user = user;
		this.score = score;
	}
	
	
	
}
