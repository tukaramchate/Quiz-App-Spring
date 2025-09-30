package com.tukaram.quizapp.controller;

import com.tukaram.quizapp.entity.ApiResponse;
import com.tukaram.quizapp.entity.Result;
import com.tukaram.quizapp.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("result")
public class ResultController {

	private final ResultService resultService;

	public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}

	@PostMapping("save")
	public ResponseEntity<ApiResponse<Result>> save(@RequestParam Long userId,
	                                              @RequestParam Integer quizId,
	                                              @RequestParam Integer score) {
		return resultService.saveResult(userId, quizId, score);
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<ApiResponse<List<Result>>> byUser(@PathVariable Long userId) {
		return resultService.getResultsByUser(userId);
	}

	@GetMapping("quiz/{quizId}")
	public ResponseEntity<ApiResponse<List<Result>>> byQuiz(@PathVariable Integer quizId) {
		return resultService.getResultsByQuiz(quizId);
	}
}


