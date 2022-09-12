package com.mphasis.Phase3_project;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}
