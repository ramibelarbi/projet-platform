package com.example.demo.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Personne;
@Repository

public interface PersonneRep extends JpaRepository<Personne,Long>{
	Personne findByEmail(String email);

}
