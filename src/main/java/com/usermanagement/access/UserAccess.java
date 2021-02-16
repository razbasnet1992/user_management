package com.usermanagement.access;

import com.usermanagement.model.User;

import java.util.regex.Pattern;

public class UserAccess {
    public boolean isFlag(User user) {
        boolean flag;
        String userPattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";

        boolean flagUsername = Pattern.compile(userPattern).matcher(user.getUsername()).matches();
        boolean flagPassword = Pattern.compile(passwordPattern).matcher(user.getPassword()).matches();
        flag = flagUsername && flagPassword;
        return flag;
    }

}
