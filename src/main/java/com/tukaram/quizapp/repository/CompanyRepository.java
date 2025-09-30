package com.tukaram.quizapp.repository;

import com.tukaram.quizapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
