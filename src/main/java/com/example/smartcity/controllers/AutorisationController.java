package com.example.smartcity.controllers;


import com.example.smartcity.models.Autorisation;
import com.example.smartcity.repos.DocumentRepository;
import com.example.smartcity.repos.PersonneRepo;
import com.example.smartcity.security.DataEncryption;
import com.example.smartcity.services.AutorisationService;
import com.example.smartcity.services.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/autorisation") @AllArgsConstructor
public class AutorisationController {


    private final AutorisationService autorisationService;

    private final DocumentRepository documentRepository;

    private final PersonneRepo personneRepo;

    private final MailService mailService;

    @PostMapping("/request/{document_id}/{user_id}")
    public ResponseEntity<String> requestAutorisation(@PathVariable Long document_id,@PathVariable Long user_id) {
        Autorisation autorisation=new Autorisation();
        Date date=new Date();
        autorisation.setDocument(documentRepository.getById(document_id));
        autorisation.setAccepted(false);
        autorisation.setDateReponse(null);
        autorisation.setRequestedAutorisation(personneRepo.getById(user_id));
        autorisation.setDateDemandeAcces(date);
        autorisationService.requestFile(autorisation) ;
        Long token=autorisationService.getIdWithDateDemandeAccess(date);
        try {
            String encryptedToken=new DataEncryption().Encrypt(String.valueOf(token));
            String reciverEmail=documentRepository.getById(document_id).getCitoyen().getEmail();
            mailService.sendEmail(reciverEmail,"http://localhost:8080/autorisation/access/"+encryptedToken);
        }
        catch (Exception e) {
             return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Request have been submitted we will wait citoyen to confirm access", HttpStatus.OK);

    }

    @GetMapping("/access/{id}")
    public ResponseEntity<String> donnerAccess (@PathVariable String id){
        String decryptId=new DataEncryption().Decrypt(id);
        autorisationService.giveAutorisation(Long.valueOf(decryptId));
        return  new ResponseEntity<>("Acces done !",HttpStatus.OK);

    }
}
