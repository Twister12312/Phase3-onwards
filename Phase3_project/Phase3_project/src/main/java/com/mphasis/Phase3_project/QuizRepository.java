package com.mphasis.Phase3_project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	@Query(value="select quiz.name, user_log.user,user_log.score "
			+ "from quiz_users "
			+ "join quiz on quiz_users.quiz_id=quiz.quiz_id "
			+ "join user_log on user_log.ul_id=quiz_users.ul_id",nativeQuery=true)
	List<Object> viewLog();
}
