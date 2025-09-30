package com.tukaram.quizapp.controller;

import com.tukaram.quizapp.entity.ApiResponse;
import com.tukaram.quizapp.entity.Question;
import com.tukaram.quizapp.entity.Quiz;
import com.tukaram.quizapp.entity.User;
import com.tukaram.quizapp.repository.QuestionRepository;
import com.tukaram.quizapp.repository.QuizRepository;
import com.tukaram.quizapp.repository.UserRepository;
import com.tukaram.quizapp.service.QuestionService;
import com.tukaram.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuizRepository quizRepository;

    // Question Management
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

    // Quiz Management
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

    // User Management
    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", users));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve users: " + e.getMessage()));
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", user.get()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve user: " + e.getMessage()));
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return ResponseEntity.ok(ApiResponse.success("User deleted successfully", null));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to delete user: " + e.getMessage()));
        }
    }

    // Statistics
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<java.util.Map<String, Long>>> getAdminStats() {
        try {
            long totalUsers = userRepository.count();
            long totalQuestions = questionRepository.count();
            long totalQuizzes = quizRepository.count();

            java.util.Map<String, Long> stats = new java.util.HashMap<>();
            stats.put("totalUsers", totalUsers);
            stats.put("totalQuestions", totalQuestions);
            stats.put("totalQuizzes", totalQuizzes);

            return ResponseEntity.ok(ApiResponse.success("Statistics retrieved successfully", stats));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to retrieve statistics: " + e.getMessage()));
        }
    }
}