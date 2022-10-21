package com.mphasis.mAadhar;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mphasis.mAadhar.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
 List<User> findByMail(String mail);
 
 @Query(value="select user.name, user.mail,user.aadharno, "
		    + "user_log.usrid, user_log.duplicate, user_log.newappln, user_log.update,user_log.status "
			+ "from user_userlog "
			+ "join user on user.uid=user_userlog.uid "
			+ "join user_log on user_log.usrid=user_userlog.usrid "
			+ "where user_log.status="+"0x00",nativeQuery=true)
	List<Object> viewLog();
 

 @Query(value="select user.uid "
			+ "from user_userlog "
			+ "join user on user.uid=user_userlog.uid "
			+ "join user_log on user_log.usrid=user_userlog.usrid "
			+ "where user_log.usrid= :id",nativeQuery=true)
	Object getId(@Param("id") Long id);
 
}
