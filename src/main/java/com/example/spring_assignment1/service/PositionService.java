package com.example.spring_assignment1.service;

import com.example.spring_assignment1.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPosition();
    Position getPositionById(Long id);
}