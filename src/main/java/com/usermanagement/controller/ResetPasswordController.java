package com.usermanagement.controller;

import com.usermanagement.exception.TokenNotFoundException;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.service.EmailService;
import com.usermanagement.service.UserService;
import com.usermanagement.util.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


@Controller
public class ResetPasswordController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @GetMapping("/forgot_password")
    public String forgotPasswordForm(){
        return "forgot_password_form";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String page ="";
        String email = request.getParameter("email");
        String token = RandomString.make(45);
        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getUrlSite(request) + "/reset_password?token=" + token;
            System.out.println(resetPasswordLink);
            emailService.sendEmail(email, resetPasswordLink);
            model.addAttribute("success", "Link is successfully sent");
           page = "login";
        } catch (UnsupportedEncodingException |MessagingException ex) {
            model.addAttribute("error", "error sending link");
        }catch (UserNotFoundException e){
        model.addAttribute("error", "User not found.Enter your correct email");
        page = "forgot_password_form";
    }
        return page;
    }

    @GetMapping("/reset_password")
    public String resetPasswordForm(@RequestParam("token")String token,Model model) {
        String page = "";
        try {
            User user = userService.findByToken(token);
                model.addAttribute("token", token);
                page = "reset_password_form";
        } catch (TokenNotFoundException te) {
            model.addAttribute("invalid_token", "Token not found.Send reset password link again.");
           page = "forgot_password_form";
        }

        return page;
    }
    @PostMapping("/reset_password")
    public String resetPassword(HttpServletRequest request,Model model) {
        String page ="";
        String token = request.getParameter("token");
        String password1 = request.getParameter("password1");

            User user = userService.findByToken(token);
        if (user!= null) {
            userService.updatePassword(user, password1);
            model.addAttribute("successful_password_change_message", "You have successfully changed your password");
            page = "login";
        }
         else {
            model.addAttribute("title", "Reset your password");
            model.addAttribute("invalid_token", "Invalid token");
            page ="reset_password_form";

        }
        return page;
    }
}
