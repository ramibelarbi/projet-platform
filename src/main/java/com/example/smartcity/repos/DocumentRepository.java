package com.example.smartcity.repos;

import com.example.smartcity.models.Document;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository  extends JpaRepository<Document,Long> {
    Optional<Document> findByOrganisationIdAndCitoyenIdAndType(Long organisationId,Long citoyenId,String type);
}
