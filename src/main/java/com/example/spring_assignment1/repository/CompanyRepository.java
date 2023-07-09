package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}