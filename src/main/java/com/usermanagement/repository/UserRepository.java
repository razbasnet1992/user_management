package com.usermanagement.repository;

import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;


public interface UserRepository {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User getUser(String username,String password);
    User getUserByUsername(String username);

    User findByEmail(String email) throws UserNotFoundException;
    User findByToken(String resetPasswordToken) throws UserNotFoundException;


}
