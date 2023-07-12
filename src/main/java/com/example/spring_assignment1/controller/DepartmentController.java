package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.model.Department;
import com.example.spring_assignment1.model.Position;
import com.example.spring_assignment1.service.DepartmentService;
import com.example.spring_assignment1.service.PositionService;
import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/department")
@Controller
public class DepartmentController {
//    @Autowired
//    private PositionService positionService;
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/")
//    public String listDepartment(Model model) {
//        model.addAttribute("departments", this.departmentService.getAllDepartment());
//        return "department-list";
//    }
//
//    @GetMapping("/add")
//    public String createAddFormDepartment(Model model, @RequestParam(required = false) String messageSuccess) {
//        if(messageSuccess != null) {
//            model.addAttribute("messageSuccess", messageSuccess);
//        }
//        model.addAttribute("department", new Department());
//        return "department-add";
//    }
//
//    @PostMapping("/add")
//    public String addDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result, Model model) {
//        if(result.hasErrors()) {
//            model.addAttribute("department", department);
//            return "department-add";
//        }
//
//        return "redirect:/user/add?messageSuccess:Adding Success";
//    }
//
//    @GetMapping("/add/position")
//    public String createAddPositionForm(Model model) {
//
//
//        return "department-add-position";
//    }
//    @PostMapping("/add/position")
//    public String addPosition(Model model) {
//
//
//        return "department-add-position";
//    }
}