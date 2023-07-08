package com.example.spring_assignment1.service.impl;

import com.example.spring_assignment1.model.User;
import com.example.spring_assignment1.repository.UserRepository;
import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}