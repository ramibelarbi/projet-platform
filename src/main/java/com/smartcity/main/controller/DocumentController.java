package com.smartcity.main.controller;

import com.smartcity.main.model.Autorisation;
import com.smartcity.main.model.Document;
import com.smartcity.main.repository.AutorisationRepository;
import com.smartcity.main.service.DocumentService;
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
    public ResponseEntity<?> download(@RequestBody Document d) throws IOException {
        try {
            List<Autorisation> au = autorisationRepository.findAll();
            au = au.stream().filter(autorisation -> autorisation.getDocument().getOrganisation().getId().equals(d.getOrganisation().getId()) && autorisation.getDocument().getCitoyen().getId().equals(d.getCitoyen().getId()) && autorisation.getDocument().getType().equals(d.getType())).collect(Collectors.toList());
            boolean authorized=au.stream().anyMatch(autorisation -> autorisation.isAccepted());
            if (authorized) {
                ResponseEntity<InputStreamResource> res = documentService.downloadDocument(d);
                return res;
            }
            else throw  new Exception("Unauthorized User");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadToLocalFileSystem(@ModelAttribute Document d) {
        System.out.println(d.toString());
        try {
            documentService.uploadDocument(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Document Ajoutée ", HttpStatus.ACCEPTED);
    }

}