package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.model.Department;
import com.example.spring_assignment1.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}