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
@Table(name = "Question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Qid;
	
	public Question(long qid, String description, String answer) {
		super();
		Qid = qid;
		this.description = description;
		this.answer = answer;
	}
	
	Question(){
		
	}
	@Column(name = "description",length=200)
	private String description;
	
	@Column(name = "answer",length=200)
	private String answer;
	
	@ManyToMany(mappedBy="questions")
	private Set<Quiz> quiz=new HashSet<Quiz>();
	
	public long getQid() {
		return Qid;
	}
	public void setQid(long qid) {
		Qid = qid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
}
