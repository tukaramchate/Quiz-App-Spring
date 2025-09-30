package com.tukaram.quizapp.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tukaram.quizapp.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}