package com.usermanagement.controller;

import com.usermanagement.model.User;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String homePage() {
       // model.addAttribute("logout_msg", "LoggedOut");
        return "login";
    }

    @GetMapping("/logout")
    public String homePage(Model model) {
        model.addAttribute("logout_msg", "You are successfully logged out.");
        return "login";

    }

    @GetMapping("/login_error")
    public String loginErrorPage(Model model) {
        model.addAttribute("error_msg", "Wrong username or password");
        return "login";
    }

    @PostMapping("/login_access")
    public String loginPage(Model model, @RequestParam String username, @RequestParam String password) {
        String page = "";
        User userInfo = userService.getUser(username, password);
        if (userInfo == null) {
            model.addAttribute("error_msg", "Wrong username or password");
            return "login";
        }

        if (username.equals(userInfo.getUsername()) && password.equals(userInfo.getPassword())) {
            model.addAttribute("username", userInfo.getUsername());
            page = "redirect:/list_user";

        }
        return page;
    }


}
