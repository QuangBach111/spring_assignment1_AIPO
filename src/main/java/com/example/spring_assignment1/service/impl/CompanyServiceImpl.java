package com.example.spring_assignment1.service.impl;

import com.example.spring_assignment1.model.Company;
import com.example.spring_assignment1.repository.CompanyRepository;
import com.example.spring_assignment1.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
        return this.companyRepository.findAll();
    }
}