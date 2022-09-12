package com.mphasis.Phase3_User_final;

import org.springframework.data.jpa.repository.JpaRepository;


import entities.UserLog;

public interface UserLogRepo extends JpaRepository<UserLog, Long>  {

}
