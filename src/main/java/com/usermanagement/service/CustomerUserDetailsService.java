package com.usermanagement.service;

import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
@Service
@Transactional
public class CustomerUserDetailsService implements UserDetailsService {
     @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        if(user ==null)
            throw new UsernameNotFoundException("User not found");
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true, getAuthorities(user.getRole().getRoleName()));
    }
    public Collection<SimpleGrantedAuthority> getAuthorities(String roleName){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleName));
        return authorities;
    }
}
