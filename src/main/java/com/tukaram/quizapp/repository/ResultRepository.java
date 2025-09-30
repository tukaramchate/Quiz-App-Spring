package com.tukaram.quizapp.repository;

import com.tukaram.quizapp.entity.Result;
import com.tukaram.quizapp.entity.User;
import com.tukaram.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
	List<Result> findByUser(User user);
	List<Result> findByQuiz(Quiz quiz);
}


