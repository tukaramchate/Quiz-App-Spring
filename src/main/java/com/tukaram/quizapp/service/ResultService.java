package com.tukaram.quizapp.service;

import com.tukaram.quizapp.entity.ApiResponse;
import com.tukaram.quizapp.entity.Quiz;
import com.tukaram.quizapp.entity.Result;
import com.tukaram.quizapp.entity.User;
import com.tukaram.quizapp.repository.ResultRepository;
import com.tukaram.quizapp.repository.UserRepository;
import com.tukaram.quizapp.dto.QuizDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

	private final ResultRepository resultRepository;
	private final UserRepository userRepository;
	private final QuizDao quizDao;

	public ResultService(ResultRepository resultRepository, UserRepository userRepository, QuizDao quizDao) {
		this.resultRepository = resultRepository;
		this.userRepository = userRepository;
		this.quizDao = quizDao;
	}

	public ResponseEntity<ApiResponse<Result>> saveResult(Long userId, Integer quizId, Integer score) {
		try {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
			Quiz quiz = quizDao.findById(quizId)
					.orElseThrow(() -> new IllegalArgumentException("Quiz not found: " + quizId));

			Result result = new Result();
			result.setUser(user);
			result.setQuiz(quiz);
			result.setScore(score);

			Result saved = resultRepository.save(result);
			return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(saved));
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ApiResponse.error(ex.getMessage()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.serverError("Failed to save result: " + ex.getMessage()));
		}
	}

	public ResponseEntity<ApiResponse<List<Result>>> getResultsByUser(Long userId) {
		return userRepository.findById(userId)
				.map(user -> ResponseEntity.ok(ApiResponse.success("Results fetched", resultRepository.findByUser(user))))
				.orElseGet(() -> ResponseEntity.badRequest().body(ApiResponse.error("User not found: " + userId)));
	}

	public ResponseEntity<ApiResponse<List<Result>>> getResultsByQuiz(Integer quizId) {
		return quizDao.findById(quizId)
				.map(quiz -> ResponseEntity.ok(ApiResponse.success("Results fetched", resultRepository.findByQuiz(quiz))))
				.orElseGet(() -> ResponseEntity.badRequest().body(ApiResponse.error("Quiz not found: " + quizId)));
	}
}


