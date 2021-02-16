package com.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        String subject = "Here is the link to reset your password";
        String content = "<p>Hello,Forgot Password Homework</p>"
                +"<p>You have requested to reset your password.</p>"
                +"<p>Click the link below.</p>"
                +"<p><b><a href = \""+resetPasswordLink+"\">Change my password</a></b></p>"
                +"<p>Ignore this email if you have not requested password reset link</p>";
        helper.setFrom("razbasnet@gmail.com","Rajendra Basnet Java 8");
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(helper.getMimeMessage());
        // Transport.send(message);
    }

}
