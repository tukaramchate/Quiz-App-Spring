package com.tukaram.quizapp.dao;

import com.tukaram.quizapp.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface QuestionDao {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

    void save(Question question);
}