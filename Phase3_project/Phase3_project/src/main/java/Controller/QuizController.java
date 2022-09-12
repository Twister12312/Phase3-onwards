package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.mphasis.Phase3_project.QuestionRepository;
import com.mphasis.Phase3_project.QuizRepository;
import com.mphasis.Phase3_project.UserLogRepo;
import com.mphasis.Phase3_project.UserRepo;

import entities.Question;
import entities.Quiz;
import entities.User;
import entities.UserLog;


@RestController
@RequestMapping("/api")
public class QuizController {

	@Autowired
	QuizRepository qrepo;
	
	@Autowired
	QuestionRepository repo2;
	
	@Autowired
	UserLogRepo urepo;
	
	@Autowired
	UserRepo usrepo;
	@PostMapping("/info") //@RequestMapping(value="/info", method="get")
    public ResponseEntity<User> createUser(@RequestBody User user ) {
    	RestTemplate resttemplate=new RestTemplate();
    	
    	usrepo.save(user);
    	//qrepo.save(oldquiz);
    	return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
@GetMapping("/questions")
	
	public ResponseEntity<List<Question>> /*String*/ getAllQuestions(/*Model m*/) {
		try {
			List<Question> questions=new ArrayList<Question>();
				//List <Tutorial>=tutorialRepository.findAll();
				//for(Tutorial t: tutorials)
				//tutorials.add(t)
				repo2.findAll().forEach(questions::add);
				//m.addAttribute("empList",tutorials);
			if(questions.isEmpty())return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				/*return "redirect:/index2.jsp";*/
			else return new ResponseEntity<>(questions,HttpStatus.OK);
			/*return "redirect:/AddQues.jsp";*/
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			//return "redirect:/index2.jsp";
		}
	}
	/************************************Update a record******************************************************/
	@PostMapping("/Quiz/{id}/{qid}")
	public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") long id, @PathVariable("qid") long qid) {
		
		//Serach for record in table
		Optional<Quiz> quizData = qrepo.findById(id);
		Optional<Question> oldques=repo2.findById(qid);
		if (quizData.isPresent()) {
			Quiz oldquiz = quizData.get();
			Question old=oldques.get();
			oldquiz.addQuestions(old);
			return new ResponseEntity<>(qrepo.save(oldquiz), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*****************************Save a new Record****************************************************/

	@PostMapping("/Quiz")
	public ResponseEntity<Quiz> createTutorial( @RequestBody Quiz newquiz ) {
		try {
			 qrepo.save(newquiz);
			
			return new ResponseEntity<>(newquiz, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	/*************************Delete question******************************************/
	@DeleteMapping("/Quiz/{id}/{qid}")
	public ResponseEntity<Quiz> removeQues(@PathVariable("id") long id, @PathVariable("qid") long qid) {
		
		//Serach for record in table
		Optional<Quiz> quizData = qrepo.findById(id);
		Optional<Question> oldques=repo2.findById(qid);
		if (quizData.isPresent()) {
			Quiz oldquiz = quizData.get();
			Question old=oldques.get();
			if(oldquiz.getQuestions().contains(old)) {
				oldquiz.getQuestions().remove(old);
			}
			//oldquiz.addQuestions(old);
			return new ResponseEntity<>(qrepo.save(oldquiz), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/********************************All statistics*****************************/
	@GetMapping("/statistic")
	public ResponseEntity<List<Object>> viewStat(){
		try{return new ResponseEntity<List<Object>>(qrepo.viewLog(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
