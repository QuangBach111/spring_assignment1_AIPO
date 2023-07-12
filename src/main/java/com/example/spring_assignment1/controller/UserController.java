package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.model.Department;
import com.example.spring_assignment1.model.Position;
import com.example.spring_assignment1.model.User;
import com.example.spring_assignment1.service.DepartmentService;
import com.example.spring_assignment1.service.PositionService;
import com.example.spring_assignment1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo,
                                Model model) {
        int pageSize = 5;

        Page<User> page = this.userService.findPaginated(pageNo, pageSize);
        List<User> users = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("items", page.getTotalElements());
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/add")
    public String createAddUserForm(Model model, @RequestParam(required = false) String messageSuccess) {
        if (messageSuccess != null) {
            model.addAttribute("messageSuccess", messageSuccess);
        }
        model.addAttribute("user", new User());
        model.addAttribute("position", new Position());
        model.addAttribute("department", new Department());
        model.addAttribute("positions", this.positionService.getAllPosition());
        model.addAttribute("departments", this.departmentService.getAllDepartment());

        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          @ModelAttribute("department") Department department,
                          @ModelAttribute("position") Position position) {

        department = this.departmentService.getDepartmentById(department.getDepartmentId());
        position = this.positionService.getPositionById(position.getPositionId());

        user.setPosition(position);
        user.setDepartment(department);
        this.userService.createOrUpdateUser(user);

        return "redirect:/user/add?messageSuccess=Adding Success";
    }

    @GetMapping("/feature-type")
    public String determineFeature(@RequestParam(value = "selectedUserIds", required = false) List<String> selectedUserIds,
                                   @RequestParam("type") String type,
                                   @RequestParam(value = "pageNo", required = false) String pageNo,
                                   Model model) {
        int pageNumber = 1;

        if (selectedUserIds == null) {
            return "redirect:/user/list/" + pageNo;
        }
        if (pageNo != null) {
            pageNumber = Integer.parseInt(pageNo);
        }

        List<Long> userIdCollection = selectedUserIds.stream()
                                                     .map(userId -> Long.parseLong(userId))
                                                     .collect(Collectors.toList());

        if (type.equals("delete")) {
            return deleteUser(userIdCollection, pageNumber);
        }

        if (type.equals("disable")) {
            return disableUser(userIdCollection, pageNumber);
        }

        return enableUser(userIdCollection, pageNumber);
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("users", this.userService.search(keyword));

        return "user-list-by-keyword";
    }

    private String deleteUser(List<Long> userIds, int pageNo) {
        this.userService.deleteUsersById(userIds);

        return "redirect:/user/list/" + pageNo;
    }

    private String disableUser(List<Long> userIds, int pageNo) {
        if (!userIds.isEmpty()) {
            this.userService.disableUsersById(userIds);
        }

        return "redirect:/user/list/" + pageNo;
    }


    private String enableUser(List<Long> userIds, int pageNo) {
        if (!userIds.isEmpty()) {
            this.userService.enableUsersById(userIds);
        }

        return "redirect:/user/list/" + pageNo;
    }
}