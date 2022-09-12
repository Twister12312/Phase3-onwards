package com.mphasis.Phase3_project;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.User;


public interface UserRepo extends JpaRepository<User, Long> {

}
