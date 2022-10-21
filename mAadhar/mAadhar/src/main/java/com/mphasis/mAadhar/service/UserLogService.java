package com.mphasis.mAadhar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.mAadhar.UserLogRepo;
import com.mphasis.mAadhar.model.User;
import com.mphasis.mAadhar.model.UserLog;

public class UserLogService {
    @Autowired UserLogRepo ulrepo;

    public UserLog addUserLog(UserLog userlog) {
	     return ulrepo.save(userlog);
}

    public List<UserLog> findAllUserLog() {
         return ulrepo.findAll();
}

    public UserLog updateUser(UserLog userlog) {
         return ulrepo.save(userlog);
}

    public void deleteUserLog(Long id) {
	     ulrepo.deleteById(id);
}

}
