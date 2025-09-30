package com.tukaram.quizapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Question title is required")
    @Size(max = 500, message = "Question title must not exceed 500 characters")
    private String questionTitle;
    
    @NotBlank(message = "Option 1 is required")
    @Size(max = 200, message = "Option 1 must not exceed 200 characters")
    private String option1;
    
    @NotBlank(message = "Option 2 is required")
    @Size(max = 200, message = "Option 2 must not exceed 200 characters")
    private String option2;
    
    @NotBlank(message = "Option 3 is required")
    @Size(max = 200, message = "Option 3 must not exceed 200 characters")
    private String option3;
    
    @NotBlank(message = "Option 4 is required")
    @Size(max = 200, message = "Option 4 must not exceed 200 characters")
    private String option4;
    
    @NotBlank(message = "Right answer is required")
    @Size(max = 255, message = "Right answer must not exceed 255 characters")
    private String rightAnswer;
    
    @Size(max = 20, message = "Difficulty level must not exceed 20 characters")
    private String difficultylevel;
    
    @NotBlank(message = "Category is required")
    @Size(max = 50, message = "Category must not exceed 50 characters")
    private String category;

}