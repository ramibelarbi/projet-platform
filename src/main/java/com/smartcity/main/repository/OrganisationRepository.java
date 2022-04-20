package com.smartcity.main.repository;

import com.smartcity.main.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository  extends JpaRepository<Organisation,Long> {
}
