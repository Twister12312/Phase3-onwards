package com.mphasis.mAadhar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.mAadhar.UserLogRepo;
import com.mphasis.mAadhar.UserRepo;
import com.mphasis.mAadhar.model.User;
import com.mphasis.mAadhar.model.UserLog;
import com.mphasis.mAadhar.model.User_temp;
import com.mphasis.mAadhar.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	private UserService userv;
	
	@Autowired
	UserRepo urepo;
	 @Autowired UserLogRepo ulrepo;

	public UserController(UserService userv) {
		super();
		this.userv = userv;
	}
	
	  @GetMapping("/all")
	    public ResponseEntity<List<User>> getAllUsers () {
	        List<User> users = userv.findAllUsers();
	        List<User_temp> usrs= new ArrayList<User_temp>();
	        for(User usr:users) {
	        	usrs.add(new User_temp(usr.getUid(),usr.getName(),usr.getGender(),
	        			usr.getmail(),usr.getDOB(),usr.getAddress(),usr.getPincode()));  }
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
/*
	    @GetMapping("/find/{id}")
	    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
	        Employee employee = employeeService.findEmployeeById(id);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }
*/
	    @PostMapping("/register")
	    public ResponseEntity<User_temp> registerUser(@RequestBody User user) {
	        User newUser = userv.addUser(user);
	        User_temp user1= new User_temp(newUser.getUid(),newUser.getName(),newUser.getGender(),
	        			newUser.getmail(),newUser.getDOB(),newUser.getAddress(),newUser.getPincode());
	        return new ResponseEntity<>(user1, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<User> updateUser(@RequestBody User user) {
	        User updateUser = userv.updateUser(user);
	        return new ResponseEntity<>(updateUser, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
	        userv.deleteUser(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/{email}")
	    public ResponseEntity<User> getUserName(@PathVariable("email") String email){
	    	List<User> newUser =  userv.findUserByMail(email);
	    	User usr=newUser.get(0);
	    	User_temp user1= new User_temp(usr.getUid(),usr.getName(),usr.getGender(),
        			usr.getmail(),usr.getDOB(),usr.getAddress(),usr.getPincode());
	    	 return new ResponseEntity<>(usr, HttpStatus.OK);}
       
	    
	    
	    @GetMapping("/login/{email}/{passwd}")
	    public ResponseEntity<User_temp> loginUser(@PathVariable("email") String email,
	    		@PathVariable("passwd") String passwd) {
	        List<User> newUser =  userv.findUserByMail(email);
	        User usr=newUser.get(0);
	        User_temp user1= new User_temp(usr.getUid(),usr.getName(),usr.getGender(),
        			usr.getmail(),usr.getDOB(),usr.getAddress(),usr.getPincode());
	        if(passwd.equals(usr.getPasswd())) {
	        System.out.println(newUser);
	        return new ResponseEntity<>(user1, HttpStatus.OK);}
	        else {
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @PutMapping("/enterlog/{email}")
	    public ResponseEntity<UserLog> EnterLog(@PathVariable("email") String email,
	    		@RequestBody UserLog entry){
	    	  List<User> newUser =  userv.findUserByMail(email);
		        User usr=newUser.get(0);
		        ulrepo.save(entry);
		        usr.addRequest(entry);
		        urepo.save(usr);
		        return new ResponseEntity<>(entry, HttpStatus.OK);
	    		
	    }
	    
	   /* @PutMapping("/updatelog/{Uid}")
	    public ResponseEntity<User> update*/

	    
}
