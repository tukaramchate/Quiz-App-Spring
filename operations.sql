create database questionsdb;
use questionsdb;

select * from question;
select * from quiz;
select * from quiz_questions;

-- Create table for Question model
CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    question_title VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    right_answer VARCHAR(255),
    difficultylevel VARCHAR(50),
    category VARCHAR(50)
);

TRUNCATE TABLE quiz;
TRUNCATE TABLE question;

SET FOREIGN_KEY_CHECKS = 0; -- Disable foreign key checks
TRUNCATE TABLE question;
SET FOREIGN_KEY_CHECKS = 1; -- Enable foreign key checks

