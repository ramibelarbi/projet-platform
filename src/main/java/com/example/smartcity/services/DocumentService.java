package com.example.smartcity.services;


import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Document;
import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.AdministrationRepo;
import com.example.smartcity.repos.DocumentRepository;
import com.example.smartcity.repos.PersonneRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
@Slf4j @AllArgsConstructor
public class DocumentService {


    private final DocumentRepository documentRepository;

    private final AdministrationRepo administrationRepo;

    private final PersonneRepo personneRepo;

    public ResponseEntity<InputStreamResource> downloadDocument(Document document) throws IOException {
        System.out.println("Calling Download:- " + "fileName");
        log.info(String.valueOf(document.getOrganisation().getId()));
        log.info(document.getCitoyen().getCin());
        Administartion administartion= administrationRepo.getById(document.getOrganisation().getId());
        Personne personne= personneRepo.getById(document.getCitoyen().getId());
        document.setCitoyen(personne);
        document.setOrganisation(administartion);
        log.info(document.getOrganisation().toString());
        ClassPathResource pdfFile = new ClassPathResource("files/" + document.getOrganisation().getId() + "/" + document.getType() + "/" + document.getCitoyen().getCin() + ".pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        headers.add("Content-Disposition", "filename=" + "fileName");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        headers.setContentLength(pdfFile.contentLength());
        ResponseEntity<InputStreamResource> response = new ResponseEntity<>(
                new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
        return response;
    }

    public void uploadDocument(Document document) throws Exception {
        Optional<Document> newDocument = documentRepository.findByOrganisationIdAndCitoyenIdAndType(document.getOrganisation().getId(), document.getCitoyen().getId(), document.getType());
        if (newDocument.isEmpty()) {
            documentRepository.save(document);
            Path path = Path.of("src/main/resources/files/" + document.getOrganisation().getId() + "/" + document.getType() + "/" + document.getCitoyen().getCin() + ".pdf");
            log.debug(String.valueOf(Files.isDirectory(path)));
            log.debug(path.toFile().getPath());
            Files.createDirectories(path.getParent());
            Files.copy(document.getFile().getInputStream(), path);
            log.info("document added successfully !");
        }
        else {
            throw  new Exception("Document Already Exists!");
        }




    }
}
