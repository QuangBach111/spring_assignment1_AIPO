package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}