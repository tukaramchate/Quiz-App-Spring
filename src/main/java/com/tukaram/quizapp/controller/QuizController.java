package com.tukaram.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tukaram.quizapp.model.ApiResponse;
import com.tukaram.quizapp.model.QuestionWrapper;
import com.tukaram.quizapp.model.Response;
import com.tukaram.quizapp.model.Quiz;
import com.tukaram.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse<Quiz>> createQuiz(
            @RequestParam String category, 
            @RequestParam int numQ, 
            @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ApiResponse<List<QuestionWrapper>>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<ApiResponse<Integer>> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

    @GetMapping("health")
    public ResponseEntity<ApiResponse<String>> healthCheck(){
        return ResponseEntity.ok(ApiResponse.success("Quiz service is running"));
    }
}