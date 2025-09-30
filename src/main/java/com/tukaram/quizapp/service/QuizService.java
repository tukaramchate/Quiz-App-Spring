package com.tukaram.quizapp.service;

import com.tukaram.quizapp.dto.QuestionDao;
import com.tukaram.quizapp.dto.QuizDao;
import com.tukaram.quizapp.entity.Question;
import com.tukaram.quizapp.entity.QuestionWrapper;
import com.tukaram.quizapp.entity.Quiz;
import com.tukaram.quizapp.entity.Response;
import com.tukaram.quizapp.entity.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    @Autowired
    private ResultService resultService;

    public ResponseEntity<ApiResponse<Quiz>> createQuiz(String category, int numQ, String title) {
        try {
            // Validate input parameters
            if (title == null || title.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Quiz title is required"));
            }
            
            if (numQ <= 0 || numQ > 50) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Number of questions must be between 1 and 50"));
            }
            
            // Get questions by category
            List<Question> questions;
            if (category == null || category.trim().isEmpty() || category.equalsIgnoreCase("all")) {
                // Get random questions from all categories
                questions = questionDao.findRandomQuestionsByCategory("", numQ);
            } else {
                questions = questionDao.findRandomQuestionsByCategory(category.trim(), numQ);
            }
            
            if (questions.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("No questions found for the specified category: " + category));
            }
            
            // Limit questions to requested number
            if (questions.size() > numQ) {
                questions = questions.subList(0, numQ);
            }

            Quiz quiz = new Quiz();
            quiz.setTitle(title.trim());
            quiz.setQuestions(questions);
            Quiz savedQuiz = quizDao.save(quiz);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.created(savedQuiz));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to create quiz: " + e.getMessage()));
        }
    }

    public ResponseEntity<ApiResponse<List<QuestionWrapper>>> getQuizQuestions(Integer id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Quiz ID is required"));
            }
            
            Optional<Quiz> quizOptional = quizDao.findById(id);
            if (quizOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.notFound("Quiz not found with ID: " + id));
            }
            
            Quiz quiz = quizOptional.get();
            List<Question> questionsFromDB = quiz.getQuestions();
            
            if (questionsFromDB == null || questionsFromDB.isEmpty()) {
                return ResponseEntity.ok(ApiResponse.success("No questions found for this quiz", new ArrayList<>()));
            }
            
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for(Question q : questionsFromDB){
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), 
                    q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(qw);
            }

            return ResponseEntity.ok(ApiResponse.success("Quiz questions retrieved successfully", questionsForUser));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to retrieve quiz questions: " + e.getMessage()));
        }
    }

    public ResponseEntity<ApiResponse<Integer>> calculateResult(Integer id, List<Response> responses) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Quiz ID is required"));
            }
            
            if (responses == null || responses.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Responses cannot be empty"));
            }
            
            Optional<Quiz> quizOptional = quizDao.findById(id);
            if (quizOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.notFound("Quiz not found with ID: " + id));
            }
            
            Quiz quiz = quizOptional.get();
            List<Question> questions = quiz.getQuestions();
            
            if (questions == null || questions.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("No questions found for this quiz"));
            }
            
            int right = 0;
            // Map responses by question id for robust scoring
            java.util.Map<Integer, String> questionIdToAnswer = new java.util.HashMap<>();
            for (Response r : responses) {
                if (r != null && r.getId() != null) {
                    questionIdToAnswer.put(r.getId(), r.getResponse());
                }
            }

            for (Question q : questions) {
                String given = questionIdToAnswer.get(q.getId());
                if (given != null && given.equals(q.getRightAnswer())) {
                    right++;
                }
            }
            
            return ResponseEntity.ok(ApiResponse.success("Quiz scored successfully", right));
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.serverError("Failed to calculate quiz result: " + e.getMessage()));
        }
    }

    // helper to also persist result if userId present
    public ResponseEntity<ApiResponse<Integer>> calculateResultAndMaybeSave(Integer id, List<Response> responses, Long userId) {
        ResponseEntity<ApiResponse<Integer>> scoreResp = calculateResult(id, responses);
        if (userId != null && scoreResp.getStatusCode().is2xxSuccessful() && scoreResp.getBody() != null && scoreResp.getBody().isSuccess()) {
            Integer score = scoreResp.getBody().getData();
            // Attempt to save result, but do not fail the scoring if save fails
            try {
                resultService.saveResult(userId, id, score);
            } catch (Exception ignored) {
            }
        }
        return scoreResp;
    }
}