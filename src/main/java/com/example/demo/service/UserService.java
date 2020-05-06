package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
//import com.example.demo.security_config.CustomUserDetails;
//import com.example.demo.security_config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        } else {
//            return new CustomUserDetails(user);
//        }
//    }

//    @Transactional
//    public UserDetails loadUserById(Long id) {
//        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
//
//        return new CustomUserDetails(user);
//    }

    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
