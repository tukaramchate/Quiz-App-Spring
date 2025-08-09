package com.tukaram.quizapp.dao;

import com.tukaram.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(
            value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",
            nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

//    void save(Question question);
}