package com.example.smartcity.controllers;


import com.example.smartcity.models.Employe;
import com.example.smartcity.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/employe")
public class EmployeController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path="/add")
    public @ResponseBody String AddNewUser(@RequestParam String nom,@RequestParam String prenom,@RequestParam String role){
        Employe employe = new Employe();
        employe.setNom(nom);
        employe.setPrenom(prenom);
        employe.setRole(role);
        userRepo.save(employe);

        return "User Created Successfully!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Employe> getAllEmployes(){
        return userRepo.findAll();
    }
}
