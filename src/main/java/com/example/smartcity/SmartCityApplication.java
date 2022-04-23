package com.example.smartcity;

import com.example.smartcity.models.Adresse;
import com.example.smartcity.models.Gouvernerat;
import com.example.smartcity.models.Personne;
import com.example.smartcity.models.Role;
import com.example.smartcity.services.PersonneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SmartCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCityApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*@Bean
    CommandLineRunner run(PersonneService personneService){
        Personne admin = new Personne();
        admin.setCin("admin");
        admin.setPassword("admin");
        admin.setRole(Role.Administrateur);
        admin.setNom("admin");
        admin.setPrenom("admin");
        admin.setDateNaissance(new Date(2000,1,1));
        admin .setAdresse(new Adresse());
        return args->{
            personneService.addPersonne(admin);
        };
    }*/
}
