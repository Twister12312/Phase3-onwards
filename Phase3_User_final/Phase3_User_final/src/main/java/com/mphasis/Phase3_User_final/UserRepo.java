package com.mphasis.Phase3_User_final;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.User;


public interface UserRepo extends JpaRepository<User, Long> {

	List<User> findByUserContaining(String user);

}
