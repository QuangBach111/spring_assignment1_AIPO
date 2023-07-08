package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.model.User;
import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listUser(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "user-list";
    }

    @GetMapping("/add")
    public String createAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "user-add";
        }
        // add user
        this.userService.createUser(user);

        return "redirect:/user/";
    }

    @GetMapping("/delete{id}")
    public String addUser(@PathVariable Long id) {
        this.userService.deleteUser(id);

        return "redirect:/user/";
    }
}