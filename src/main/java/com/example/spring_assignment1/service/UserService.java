package com.example.spring_assignment1.service;

import com.example.spring_assignment1.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    void createOrUpdateUser(User user);
    void deleteUser(Long id);
    void deleteUsersById(List<Long> userIds);
    void disableUsersById(List<Long> userIds);
    void enableUsersById(List<Long> userIds);
    Page<User> findPaginated(int pageNo, int pageSize);

    List<User> search(String name);
}