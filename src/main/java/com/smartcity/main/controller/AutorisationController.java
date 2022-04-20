package com.smartcity.main.controller;


import com.smartcity.main.model.Autorisation;
import com.smartcity.main.repository.DocumentRepository;
import com.smartcity.main.repository.UserRepository;
import com.smartcity.main.security.DataEncryption;
import com.smartcity.main.service.AutorisationService;
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
        String encryptedToken=new DataEncryption().Encrypt(String.valueOf(token));
        return new ResponseEntity<>(encryptedToken, HttpStatus.OK);

    }

    @GetMapping("/access/{id}")
    public ResponseEntity<String> donnerAccess (@PathVariable String id){
        String decryptId=new DataEncryption().Decrypt(id);
        autorisationService.GetAutorisation(Long.valueOf(decryptId));
        return  new ResponseEntity<>(decryptId,HttpStatus.OK);

    }
}
