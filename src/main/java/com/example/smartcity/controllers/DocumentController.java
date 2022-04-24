package com.example.smartcity.controllers;

import com.example.smartcity.models.Autorisation;
import com.example.smartcity.models.Document;
import com.example.smartcity.repos.AutorisationRepository;
import com.example.smartcity.services.DocumentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/pdf")
public class DocumentController {

    @Autowired
    DocumentService documentService;
    @Autowired
    AutorisationRepository autorisationRepository;

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<?> download(@RequestBody Document document) throws IOException {
        try {
            List<Autorisation> autorisations = autorisationRepository.findAll();
            autorisations = autorisations.stream().filter(autorisation -> autorisation.getDocument().getOrganisation().getId()==(document.getOrganisation().getId()) && autorisation.getDocument().getCitoyen().getId().equals(document.getCitoyen().getId()) && autorisation.getDocument().getType().equals(document.getType())).collect(Collectors.toList());
            boolean authorized=autorisations.stream().anyMatch(autorisation -> autorisation.isAccepted());
            if (authorized) {
                ResponseEntity<InputStreamResource> response = documentService.downloadDocument(document);
                return response;
            }
            else throw  new Exception("Unauthorized User");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadToLocalFileSystem(@ModelAttribute Document document) {
        System.out.println(document.toString());
        try {
            documentService.uploadDocument(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Document Ajoutée ", HttpStatus.ACCEPTED);
    }

}