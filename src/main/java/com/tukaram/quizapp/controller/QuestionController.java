package com.tukaram.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tukaram.quizapp.model.ApiResponse;
import com.tukaram.quizapp.model.Question;
import com.tukaram.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<ApiResponse<List<Question>>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<ApiResponse<List<Question>>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<ApiResponse<Question>> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("health")
    public ResponseEntity<ApiResponse<String>> healthCheck(){
        return ResponseEntity.ok(ApiResponse.success("Question service is running"));
    }
}