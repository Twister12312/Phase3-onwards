package com.mphasis.mAadhar.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.mphasis.mAadhar.service.UserService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	private UserService userv;
	
	@Autowired
	UserRepo urepo;
	@Autowired UserLogRepo ulrepo;
    
	public AdminController(UserService userv) {
		super();
		this.userv = userv;
	}
	
	@GetMapping("/log")
	public ResponseEntity<List<Object>> getAlllogs(){
		
		List<Object> logs= urepo.viewLog();
		
		 return new ResponseEntity<>(logs, HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}/{status}")
	public ResponseEntity<UserLog> updateStatus(@PathVariable("id") Long id,
			@PathVariable("status") boolean status
			)
	{
		Optional<UserLog> usr=ulrepo.findById(id);
		UserLog userlg=usr.get();
		userlg.setStatus(status);
		ulrepo.save(userlg);
		if(userlg.isNewappln()==true) {
			Object u=urepo.getId(id);
			String u1=String.valueOf(u);
			Long uid=Long.parseLong(u1);
			Optional<User> temp_user=urepo.findById(uid);
			User user=temp_user.get();
			user.setAadharno(generateRandom());
			urepo.save(user);
			//find original user
			//assign aadhar
		}
		return new ResponseEntity<>(userlg, HttpStatus.OK);
		
		
		
	}
	
	
	public String generateRandom() {
	    int length=12;
		Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return new String(digits);
	}
	
	

}
