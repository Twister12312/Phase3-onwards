package com.mphasis.mAadhar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mphasis.mAadhar.UserRepo;
import com.mphasis.mAadhar.model.User;
@Service
@Transactional
public class UserService {

	@Autowired
	UserRepo urepo;
	
	public User addUser(User user) {
		return urepo.save(user);
	}
	
	public List<User> findAllUsers() {
        return urepo.findAll();
    }

    public User updateUser(User user) {
        return urepo.save(user);
    }
    
    public void deleteUser(Long id) {
    	urepo.deleteById(id);
    }
    
    public List<User> findUserByMail(String mail) {
    	return urepo.findByMail(mail);
    }
	
}
