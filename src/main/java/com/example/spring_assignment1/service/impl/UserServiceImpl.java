package com.example.spring_assignment1.service.impl;

import com.example.spring_assignment1.model.User;
import com.example.spring_assignment1.repository.UserRepository;
import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void createOrUpdateUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteUsersById(List<Long> userIds) {
        this.userRepository.deleteByUserIdIn(userIds);
    }

    @Transactional
    @Override
    public void disableUsersById(List<Long> userIds) {
        this.userRepository.updateDisableStatusByUserIdIn(true, userIds);
    }

    @Transactional
    @Override
    public void enableUsersById(List<Long> userIds) {
        this.userRepository.updateDisableStatusByUserIdIn(false, userIds);
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);

        return this.userRepository.findAll(pageable);
    }

    @Override
    public List<User> search(String name) {
        return this.userRepository.search(name);
    }
}