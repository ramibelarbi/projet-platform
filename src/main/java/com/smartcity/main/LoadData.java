package com.smartcity.main;


import com.smartcity.main.model.User;
import com.smartcity.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public class LoadData implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        ArrayList<User> users =new ArrayList<User>() ;
        users.add(new User(0L,"0121345","nejah","nejah","najehbenabdelkader@gmail.com"));
        users.add(new User(0L,"4657987","dhia","dhia",null));
        users.add(new User(0L,"0475035","rami","rami",null));

        userRepository.saveAll(users);


    }
}
