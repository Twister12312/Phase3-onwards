package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.Phase3_User_final.QuestionRepository;
import com.mphasis.Phase3_User_final.QuizRepository;
import com.mphasis.Phase3_User_final.UserLogRepo;
import com.mphasis.Phase3_User_final.UserRepo;

import entities.Answer;
import entities.Question;
import entities.Quiz;
import entities.User;
import entities.UserLog;


@RestController
@RequestMapping("/webapi")
public class UserController {
    String password;
	String username;
	int count=0;
	int score=0;
	@Autowired
	UserLogRepo urepo;
	
	 @Autowired
	    UserService service;
	 
	 @Autowired
	 QuizRepository qrepo;
	 
	 @Autowired
		UserRepo usrepo;
	 
	 @Autowired
		QuestionRepository repo2;
/***********************************Check login*****************************************/	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User user ) {
	
		try{List<User> userData = new ArrayList<User>();
		usrepo.findByUserContaining(user.getUser()).forEach(userData::add);
		if(userData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else { 
			username=userData.get(0).getUser();
		    password=userData.get(0).getPass();
		    if(password.equals(user.getPass()))
		    	return new ResponseEntity<>(userData.get(0),HttpStatus.OK);}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		//urepo.save(user);
		//service.addUser(user);
		//service.addUser(pe);
	}
	/***************************Display question************************************/
	@GetMapping("/question/{id}/{qid}")
	public ResponseEntity<String> showQues(@PathVariable("id") long id, @PathVariable("qid") long qid){
		try{Optional<Quiz> quizData = qrepo.findById(id);
		
		Optional<Question> quesData=repo2.findById(qid);
		if (quizData.isPresent()&&quesData.isPresent()) {
			Quiz oldquiz = quizData.get();
			Question oldques=quesData.get();
			if(oldquiz.getQuestions().contains(oldques)) {
			
				return new ResponseEntity<String>(oldques.getDescription(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			
		}}
		catch(Exception e) {
			return new ResponseEntity<String>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
   /*******************************Post answer****************************************/	
	@PostMapping("/question/{id}/{qid}")
	public ResponseEntity<String> giveAns(@PathVariable("id") long id,
			@PathVariable("qid") long qid, @RequestBody Answer ans
			)
	{
         try{Optional<Quiz> quizData = qrepo.findById(id);
		Optional<Question> quesData=repo2.findById(qid);
		if (quizData.isPresent()&&quesData.isPresent()) {
			Quiz oldquiz = quizData.get();
			Question oldques=quesData.get();
			if(oldquiz.getQuestions().contains(oldques)) {
				count++;
				if(oldques.getAnswer().equals(ans.getAnswer())) {score++;
				}
				if(count==oldquiz.getQuestions().size()) {
					
					UserLog u= new UserLog(username,
							score);
					oldquiz.addEntries(u);
					urepo.save(u);
					qrepo.save(oldquiz);
					int sc=score;
					String scr=Integer.toString(sc);
					count=0;
					score=0;
					return new ResponseEntity<String>("Ans: "+oldques.getAnswer()+"  score: "+scr,HttpStatus.OK);
				}
				return new ResponseEntity<String>("Ans: "+oldques.getAnswer(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			
		}}
         catch(Exception e) {
 			return new ResponseEntity<String>( HttpStatus.INTERNAL_SERVER_ERROR);
 		}
 		return null;
		
	}
/************************************End of********************************************/	
	
}
