package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
}