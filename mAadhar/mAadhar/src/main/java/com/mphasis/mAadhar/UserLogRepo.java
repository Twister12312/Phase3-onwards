package com.mphasis.mAadhar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.mAadhar.model.UserLog;


public interface UserLogRepo extends JpaRepository<UserLog, Long> {

}
