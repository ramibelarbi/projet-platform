package com.example.smartcity.controllers;

import com.example.smartcity.models.Ecole;
import com.example.smartcity.services.EcoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/administration/ecole")
@AllArgsConstructor
public class EcoleController {
    EcoleService ecoleService;

    @GetMapping("/all")
    ResponseEntity<List<Ecole>> getAllEcole(){
        List<Ecole> ecoles = ecoleService.getAllEcoles();
        return new ResponseEntity<>(ecoles, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    ResponseEntity<Ecole> getEcole(@PathVariable("id") Long id){
        Ecole ecole = ecoleService.getEcole(id);
        return new ResponseEntity<>(ecole,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Ecole> addEcole(@RequestBody Ecole ecole){
        Ecole newEcole = ecoleService.addEcole(ecole);
        return new ResponseEntity<>(ecole,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Ecole> updateEcole(@RequestBody Ecole ecole){
        Ecole newEcole = ecoleService.updateEcole(ecole);
        return new ResponseEntity<>(ecole,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteEcole(@PathVariable("id") Long id){
        ecoleService.deleteEcole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}