package com.tukaram.quizapp.repository;

import com.tukaram.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    
    List<Question> findByCategoryIgnoreCase(String category);
    
    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
    
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("numQ") int numQ);
    
    List<Question> findByDifficultylevelIgnoreCase(String difficultyLevel);
    
    List<Question> findByCategoryIgnoreCaseAndDifficultylevelIgnoreCase(String category, String difficultyLevel);
}
