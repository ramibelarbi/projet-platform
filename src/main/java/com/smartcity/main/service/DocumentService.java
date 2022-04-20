package com.smartcity.main.service;

import com.smartcity.main.model.Document;
import com.smartcity.main.model.Organisation;
import com.smartcity.main.model.User;
import com.smartcity.main.repository.DocumentRepository;
import com.smartcity.main.repository.OrganisationRepository;
import com.smartcity.main.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
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
@Slf4j
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    OrganisationRepository organisationRepository;
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<InputStreamResource> downloadDocument(Document d) throws IOException {
        System.out.println("Calling Download:- " + "fileName");
        log.info(String.valueOf(d.getOrganisation().getId()));
        log.info(d.getCitoyen().getCin());
        Organisation o=organisationRepository.getById(d.getOrganisation().getId());
        User u=userRepository.getById(d.getCitoyen().getId());
        d.setCitoyen(u);
        d.setOrganisation(o);
        log.info(d.getOrganisation().toString());
        ClassPathResource pdfFile = new ClassPathResource("files/" + d.getOrganisation().getFullName() + "/" + d.getType() + "/" + d.getCitoyen().getCin() + ".pdf");
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
        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
                new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
        return response;
    }

    public void uploadDocument(Document d) throws Exception {
        Optional<Document> document = documentRepository.findByOrganisationIdAndCitoyenIdAndType(d.getOrganisation().getId(), d.getCitoyen().getId(), d.getType());
        if (document.isEmpty()) {
            documentRepository.save(d);
            Path path = Path.of("src/main/resources/files/" + d.getOrganisation().getFullName() + "/" + d.getType() + "/" + d.getCitoyen().getCin() + ".pdf");
            log.debug(String.valueOf(Files.isDirectory(path)));
            log.debug(path.toFile().getPath());
            Files.createDirectories(path.getParent());
            Files.copy(d.getFile().getInputStream(), path);
            log.info("document added succesfully");
        }
        else {
            throw  new Exception("Document Alredy Exist!");
        }




    }
}
