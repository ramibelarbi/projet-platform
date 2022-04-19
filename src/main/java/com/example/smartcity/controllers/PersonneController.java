package com.example.smartcity.controllers;


import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.PersonneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/personne")
public class PersonneController {
    @Autowired
    PersonneRepo personneRepo;

    @PostMapping("/add")
    public @ResponseBody String ajouterPersonne(@RequestParam String cin,@RequestParam String nom,@RequestParam String prenom){
        Personne personne = new Personne();
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personne.setCin(cin);
        personneRepo.save(personne);
        return "Creation avec success !!!";
    }
}
