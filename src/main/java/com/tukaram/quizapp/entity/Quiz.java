package com.tukaram.quizapp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // audit fields
    @ManyToOne
    @JoinColumn(name = "created_by_teacher_id")
    private User createdByTeacher;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}