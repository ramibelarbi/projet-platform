package com.smartcity.main.service;

import com.smartcity.main.model.User;
import com.smartcity.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;

     public void AddUser(User user) {
         userRepository.save(user);
     }
}
