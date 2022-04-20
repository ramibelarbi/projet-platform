package com.smartcity.main.controller;


import com.smartcity.main.model.Organisation;
import com.smartcity.main.service.OrganisationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;

    @PostMapping(value = "/add")
    public ResponseEntity<String>  AddOrganisation(@RequestBody Organisation o) {
        try {
            organisationService.AddOrganisation(o.getFullName());
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisation> getOrganisation(@PathVariable Long id) {
        Organisation organisation=organisationService.getOrganisation(id);
        return new ResponseEntity<>(organisation,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteOrganisation(@PathVariable Long id) {
        organisationService.DeleteOrganisation(id);
        return new ResponseEntity<>("Deleted With Succes",HttpStatus.OK);
    }

}
