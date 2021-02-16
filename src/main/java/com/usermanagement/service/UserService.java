package com.usermanagement.service;

import com.usermanagement.exception.TokenNotFoundException;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User getUser(String username,String password);
    User findByEmail(String email) throws UserNotFoundException;
    User findByToken(String resetPasswordToken) throws TokenNotFoundException;
    void updateResetPasswordToken(String token,String email) throws UserNotFoundException;
    void updatePassword(User user,String token);

}
