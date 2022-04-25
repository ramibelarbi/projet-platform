package com.example.smartcity.controllers;

import com.example.smartcity.models.Reclamation;
import com.example.smartcity.repos.AdministrationRepo;
import com.example.smartcity.repos.PersonneRepo;

import com.example.smartcity.services.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/reclamations")@AllArgsConstructor @CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class ReclamationController {
    private final ReclamationService reclamationService;
    public final PersonneRepo personneRepo;
    public final AdministrationRepo administrationRepo;
    @PostMapping("/add")
    ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation reclamation){
        Reclamation newReclamation =reclamationService.addReclamation(reclamation);
        return new ResponseEntity<>(newReclamation, HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    ResponseEntity<Reclamation> getReclamation(@PathVariable Long id){
        Reclamation reclamation = reclamationService.getReclamation(id);
        return new ResponseEntity<>(reclamation, HttpStatus.OK);
    }
    @GetMapping("/citoyen/{id}")
    ResponseEntity<List<Reclamation>> getReclamationCitoyen(@PathVariable Long id){
        List<Reclamation> reclamations = reclamationService.getReclamationsCitoyen(personneRepo.findPersonneById(id).get());
        return new ResponseEntity<>(reclamations, HttpStatus.OK);
    }
    @GetMapping("/administration/{id}")
    ResponseEntity<List<Reclamation>> getReclamationAdministration(@PathVariable Long id){
        List<Reclamation> reclamations = reclamationService.getReclamationsAdministration(administrationRepo.getById(id));
        return new ResponseEntity<>(reclamations, HttpStatus.OK);
    }
}
