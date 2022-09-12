package com.mphasis.Phase3_User_final;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}
