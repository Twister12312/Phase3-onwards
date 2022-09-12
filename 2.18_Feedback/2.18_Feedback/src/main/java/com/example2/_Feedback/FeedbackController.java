package com.example2._Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/webapi") 
public class FeedbackController {

    @Autowired
    FeedbackService feedbackservice;
    
    @PostMapping("/feedback")   //@REquestBody is used to read object from browser
    public void addFeedback(@RequestBody Feedback fe ) {
        feedbackservice.addFeedback(fe);
    }
    
    
}
