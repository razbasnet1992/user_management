package com.usermanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {
   public static String encodePassword(String password){
       // @Autowired
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
        //System.out.println(password);
    }

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("user");
      //String encodedPassword = encoder.encode(password);
        System.out.println(password);

    }
}
