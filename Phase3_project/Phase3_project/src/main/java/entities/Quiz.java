package entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
	
	public Quiz(long quiz_id, String nam) {
		super();
		Quiz_id = quiz_id;
		name = nam;
	}
	Quiz(){
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Quiz_id;
	
	@Column(name = "name",length=50)
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Quiz_Questions", joinColumns= {@JoinColumn(name="Quiz_id")}, inverseJoinColumns= {@JoinColumn(name="Qid")})
	private Set<Question> questions=new HashSet<Question>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Quiz_users", joinColumns= {@JoinColumn(name="Quiz_id")}, inverseJoinColumns= {@JoinColumn(name="ul_id")})
	private Set<UserLog> entries=new HashSet<UserLog>();
	public long getQuiz_id() {
		return Quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		Quiz_id = quiz_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nam) {
		name = nam;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public void addQuestions(Question oldques) {
		this.questions.add(oldques);
	}
	public void addEntries(UserLog u) {
		this.entries.add(u);
	}
	
	
}
