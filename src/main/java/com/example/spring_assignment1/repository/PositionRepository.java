package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}