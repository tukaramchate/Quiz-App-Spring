package com.tukaram.quizapp.repository;

import com.tukaram.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    
    List<Quiz> findByTitleContainingIgnoreCase(String title);
    
    @Query("SELECT q FROM Quiz q WHERE q.title LIKE %:title%")
    List<Quiz> findByTitleLike(@Param("title") String title);
    
    @Query("SELECT q FROM Quiz q JOIN q.questions qu WHERE qu.category = :category")
    List<Quiz> findByQuestionsCategory(@Param("category") String category);
    
    Optional<Quiz> findByIdAndTitle(Integer id, String title);
    
    @Query("SELECT COUNT(q) FROM Quiz q")
    long countAllQuizzes();
    
    @Query("SELECT q FROM Quiz q ORDER BY q.id DESC")
    List<Quiz> findAllOrderByIdDesc();
}
