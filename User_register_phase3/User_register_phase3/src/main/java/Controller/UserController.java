package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.User;

@RestController
@RequestMapping("/user")
public class UserController {

	  @Autowired
	    UserService service;
	  
	    
	    @PostMapping(value="/register")   
	    public void addPerson(@RequestBody User u ) {
	    	//return u;
	        service.addUser(u);
	       
	    }
}
