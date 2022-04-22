package com.smartcity.main.controller;


import com.smartcity.main.model.Autorisation;
import com.smartcity.main.repository.DocumentRepository;
import com.smartcity.main.repository.UserRepository;
import com.smartcity.main.security.DataEncryption;
import com.smartcity.main.service.AutorisationService;
import com.smartcity.main.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/autorisation")
public class AutorisationController {

    @Autowired
    AutorisationService autorisationService;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailService mailService;

    @PostMapping("/request/{document_id}/{user_id}")
    public ResponseEntity<String> requestAutorisation(@PathVariable Long document_id,@PathVariable Long user_id) {
        Autorisation au=new Autorisation();
        Date date=new Date();
        au.setDocument(documentRepository.getById(document_id));
        au.setAccepted(false);
        au.setDateReponse(null);
        au.setRequestedAutorisation(userRepository.getById(user_id));
        au.setDateDemandeAcces(date);
        autorisationService.requestFile(au) ;
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
        autorisationService.GetAutorisation(Long.valueOf(decryptId));
        return  new ResponseEntity<>("Acces done !",HttpStatus.OK);

    }
}
