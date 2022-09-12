package com.mphasis.Phase3_project;

import org.springframework.data.jpa.repository.JpaRepository;


import entities.UserLog;

public interface UserLogRepo extends JpaRepository<UserLog, Long>  {

}
