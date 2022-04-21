package com.example.smartcity.controllers;

import com.example.smartcity.models.Administartion;
import com.example.smartcity.services.AdministrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/administration")
@AllArgsConstructor
public class AdministrationController {
    AdministrationService administrationService;

    @GetMapping("/all")
    ResponseEntity<List<Administartion>> getAllAdministrations(){
        List<Administartion> administartions = administrationService.getAllAdministartions();
        return new ResponseEntity<>(administartions,HttpStatus.OK);
    }

}
