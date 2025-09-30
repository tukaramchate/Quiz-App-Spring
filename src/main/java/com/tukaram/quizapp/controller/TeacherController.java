package com.tukaram.quizapp.controller;

import com.tukaram.quizapp.entity.ApiResponse;
import com.tukaram.quizapp.entity.Question;
import com.tukaram.quizapp.entity.Quiz;
import com.tukaram.quizapp.entity.Result;
import com.tukaram.quizapp.repository.QuestionRepository;
import com.tukaram.quizapp.repository.QuizRepository;
import com.tukaram.quizapp.repository.ResultRepository;
import com.tukaram.quizapp.service.QuestionService;
import com.tukaram.quizapp.service.QuizService;
import com.tukaram.quizapp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private ResultService resultService;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuizRepository quizRepository;
    
    @Autowired
    private ResultRepository resultRepository;

    // Question Management for Teachers
    @PostMapping("/questions")
    public ResponseEntity<ApiResponse<Question>> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/questions")
    public ResponseEntity<ApiResponse<List<Question>>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/category/{category}")
    public ResponseEntity<ApiResponse<List<Question>>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<ApiResponse<Question>> getQuestionById(@PathVariable Integer id) {
        try {
            Optional<Question> question = questionRepository.findById(id);
            if (question.isPresent()) {
                return ResponseEntity.ok(ApiResponse.success("Question retrieved successfully", question.get()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve question: " + e.getMessage()));
        }
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<ApiResponse<Question>> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        try {
            if (questionRepository.existsById(id)) {
                question.setId(id);
                Question updatedQuestion = questionRepository.save(question);
                return ResponseEntity.ok(ApiResponse.success("Question updated successfully", updatedQuestion));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to update question: " + e.getMessage()));
        }
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<ApiResponse<String>> deleteQuestion(@PathVariable Integer id) {
        try {
            if (questionRepository.existsById(id)) {
                questionRepository.deleteById(id);
                return ResponseEntity.ok(ApiResponse.success("Question deleted successfully", null));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to delete question: " + e.getMessage()));
        }
    }

    // Quiz Management for Teachers
    @PostMapping("/quizzes")
    public ResponseEntity<ApiResponse<Quiz>> createQuiz(@RequestParam String category, 
                                                      @RequestParam int numQ, 
                                                      @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/quizzes")
    public ResponseEntity<ApiResponse<List<Quiz>>> getAllQuizzes() {
        try {
            List<Quiz> quizzes = quizRepository.findAllOrderByIdDesc();
            return ResponseEntity.ok(ApiResponse.success("Quizzes retrieved successfully", quizzes));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve quizzes: " + e.getMessage()));
        }
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<ApiResponse<Quiz>> getQuizById(@PathVariable Integer id) {
        try {
            Optional<Quiz> quiz = quizRepository.findById(id);
            if (quiz.isPresent()) {
                return ResponseEntity.ok(ApiResponse.success("Quiz retrieved successfully", quiz.get()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve quiz: " + e.getMessage()));
        }
    }

    @DeleteMapping("/quizzes/{id}")
    public ResponseEntity<ApiResponse<String>> deleteQuiz(@PathVariable Integer id) {
        try {
            if (quizRepository.existsById(id)) {
                quizRepository.deleteById(id);
                return ResponseEntity.ok(ApiResponse.success("Quiz deleted successfully", null));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to delete quiz: " + e.getMessage()));
        }
    }

    // Results Management for Teachers
    @GetMapping("/results")
    public ResponseEntity<ApiResponse<List<Result>>> getAllResults() {
        try {
            List<Result> results = resultRepository.findAll();
            return ResponseEntity.ok(ApiResponse.success("Results retrieved successfully", results));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve results: " + e.getMessage()));
        }
    }

    @GetMapping("/results/quiz/{quizId}")
    public ResponseEntity<ApiResponse<List<Result>>> getResultsByQuiz(@PathVariable Integer quizId) {
        return resultService.getResultsByQuiz(quizId);
    }

    @GetMapping("/results/user/{userId}")
    public ResponseEntity<ApiResponse<List<Result>>> getResultsByUser(@PathVariable Long userId) {
        return resultService.getResultsByUser(userId);
    }

    // Teacher Statistics
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<java.util.Map<String, Long>>> getTeacherStats() {
        try {
            long totalQuestions = questionRepository.count();
            long totalQuizzes = quizRepository.count();
            long totalResults = resultRepository.count();

            java.util.Map<String, Long> stats = new java.util.HashMap<>();
            stats.put("totalQuestions", totalQuestions);
            stats.put("totalQuizzes", totalQuizzes);
            stats.put("totalResults", totalResults);

            return ResponseEntity.ok(ApiResponse.success("Statistics retrieved successfully", stats));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve statistics: " + e.getMessage()));
        }
    }
}