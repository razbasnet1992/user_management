package com.usermanagement.service;

import com.usermanagement.exception.TokenNotFoundException;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.Role;
import com.usermanagement.model.User;

import com.usermanagement.repository.UserRepository;
import com.usermanagement.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.tools.jstat.Token;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        //User userInfo = new User();
        String encodedPassword = PasswordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        Role role = new Role();
        role.setId(2);
        role.setRoleName("user");
        user.setRole(role);
                userRepository.saveUser(user);
    }

    @Override

    public void updateUser(User user) {
        String encodedPassword = PasswordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(encodedPassword);userRepository.updateUser(user);
    }

    @Override

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(String username, String password) {

        return userRepository.getUser(username, password);
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByToken(String resetPasswordToken) throws TokenNotFoundException {
        User user =userRepository.findByToken(resetPasswordToken);
        if(user==null)
        throw new TokenNotFoundException("Token not found");
        return user;
    }

    //
    public void updateResetPasswordToken(String token,String email) throws UserNotFoundException{
        User user = userRepository.findByEmail(email);
        if(user!=null){
            user.setResetPasswordToken(token);
            userRepository.updateUser(user);
        }else{
            throw new UserNotFoundException("could not find User with the email "+email);
        }
    }
    public void updatePassword(User user,String newPassword){
       String encodedPassword = PasswordEncoderUtil.encodePassword(newPassword);
       user.setPassword(encodedPassword);
       user.setResetPasswordToken(null);
       userRepository.updateUser(user);
    }
}
