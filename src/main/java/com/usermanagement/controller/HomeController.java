package com.usermanagement.controller;

import com.usermanagement.access.UserAccess;

import com.usermanagement.model.User;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;


    @GetMapping("/add_user")
    public String addUser() {
        return "signup";
    }

    @PostMapping("/add_user")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/list_user";
    }

    @GetMapping("/list_user")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list",list);
        return "usersList";
    }

    @GetMapping("/delete_user")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/list_user";
    }

    @GetMapping("/edit_user")
    public String editUser(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateform";
    }

    @PostMapping("/edit_user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/list_user";
    }
}
