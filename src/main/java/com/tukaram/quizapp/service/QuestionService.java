package com.tukaram.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tukaram.quizapp.dao.QuestionDao;
import com.tukaram.quizapp.model.ApiResponse;
import com.tukaram.quizapp.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    
    public ResponseEntity<ApiResponse<List<Question>>> getAllQuestions() {
        try {
            List<Question> questions = questionDao.findAll();
            if (questions.isEmpty()) {
                return ResponseEntity.ok(ApiResponse.success("No questions found", questions));
            }
            return ResponseEntity.ok(ApiResponse.success("Questions retrieved successfully", questions));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to retrieve questions: " + e.getMessage()));
        }
    }

    public ResponseEntity<ApiResponse<List<Question>>> getQuestionsByCategory(String category) {
        try {
            if (category == null || category.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Category cannot be null or empty"));
            }
            
            List<Question> questions = questionDao.findByCategoryIgnoreCase(category.trim());
            if (questions.isEmpty()) {
                return ResponseEntity.ok(ApiResponse.success("No questions found for category: " + category, questions));
            }
            return ResponseEntity.ok(ApiResponse.success("Questions retrieved successfully for category: " + category, questions));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to retrieve questions by category: " + e.getMessage()));
        }
    }

    public ResponseEntity<ApiResponse<Question>> addQuestion(Question question) {
        try {
            // Validate question data
            if (question == null) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Question cannot be null"));
            }
            
            if (question.getQuestionTitle() == null || question.getQuestionTitle().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Question title is required"));
            }
            
            if (question.getOption1() == null || question.getOption1().trim().isEmpty() ||
                question.getOption2() == null || question.getOption2().trim().isEmpty() ||
                question.getOption3() == null || question.getOption3().trim().isEmpty() ||
                question.getOption4() == null || question.getOption4().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("All four options are required"));
            }
            
            if (question.getRightAnswer() == null || question.getRightAnswer().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Right answer is required"));
            }
            
            // Set default values if not provided
            if (question.getDifficultylevel() == null || question.getDifficultylevel().trim().isEmpty()) {
                question.setDifficultylevel("Medium");
            }
            
            Question savedQuestion = questionDao.save(question);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.created(savedQuestion));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to add question: " + e.getMessage()));
        }
    }
}