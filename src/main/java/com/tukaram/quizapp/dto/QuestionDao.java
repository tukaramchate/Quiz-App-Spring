package com.tukaram.quizapp.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tukaram.quizapp.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
    
    @Query("SELECT q FROM Question q WHERE LOWER(q.category) = LOWER(:category)")
    List<Question> findByCategoryIgnoreCase(@Param("category") String category);

    @Query(
            value = "SELECT * FROM question q WHERE (:category IS NULL OR :category = '' OR LOWER(q.category) = LOWER(:category)) ORDER BY RAND() LIMIT :numQ",
            nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

//    void save(Question question);
}