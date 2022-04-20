package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Sms.Smsrequest;
import com.example.demo.Sms.Smsservice;
import com.example.demo.model.Personne;
import com.example.demo.repositry.PersonneRep;
@RestController
@RequestMapping("/api/v1/")
public class PersonneController {
	@Autowired
	private PersonneRep Personnerep;
	@Autowired
	Smsservice smsservice;
	@GetMapping("/Personne")
	public List<Personne> getallPersonne(){
		return Personnerep.findAll();
	}
	@PostMapping("/Personne")
	public Personne createPrsonne(@RequestBody Personne personne) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		personne.setMot_de_pasee(encoder.encode(personne.getMot_de_pasee()));
		personne.setEnabled(true);
		return Personnerep.save(personne);
	}
	@GetMapping("/Personne/{id}")
	public Personne getPersonnebycin(@PathVariable ("id") Long id) {
		Personne personne=Personnerep.findById(id).orElse(null);
		return personne;
	}
	@PutMapping("/Personne/{id}")
	public Personne updatePersonne(@PathVariable ("id") Long id,@RequestBody Personne personnedetails){
		Personne personne=Personnerep.findById(id).orElse(null);
		personne.setId(personnedetails.getId());
		personne.setCin(personnedetails.getCin());
		personne.setDate_de_naissance(personnedetails.getDate_de_naissance());
		personne.setEmail(personnedetails.getEmail());
		personne.setMot_de_pasee(personnedetails.getMot_de_pasee());
		personne.setNom(personnedetails.getNom());
		personne.setPrenom(personnedetails.getPrenom());
		personne.setRole(personnedetails.getRole());
		return Personnerep.save(personnedetails);
	}
	@DeleteMapping("/Personne/{id}")
	public boolean deletePersonne(@PathVariable ("id") Long id) {

	    Personne personne = Personnerep.findById(id).orElse(null);
	    Personnerep.deleteById(id);
	    return true;
	}
	@PostMapping("/Sms")
	public void Smssender()
	{
		Smsrequest smsrequest = new Smsrequest("+21653687285", "yassin");
		smsservice.sendsms(smsrequest);
	}
	}
