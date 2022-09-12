package com.example2._Feedback;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FeedbackService {

	  @Autowired
	    FeedbackRepository feedrep;//reference object of interface
	  
	   public void addFeedback(Feedback fe){
	        feedrep.save(fe);
	    }
	
}
