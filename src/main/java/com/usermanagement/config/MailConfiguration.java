package com.usermanagement.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
public class MailConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
//          String username = "razbasnet@gmail.com";
//          String password = "razendra";
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable","true");
        javaMailProperties.put("mail.smtp.host", "smtp.gmail.com");
        javaMailProperties.put("mail.smtp.port",587);
        javaMailProperties.put("mail.smtp.auth","true");
        javaMailProperties.put("mail.transport.protocol","smtp");
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        };
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}
