package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table (name = "personne")
public class Personne {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private double cin;
	private String nom;
	private String prenom;
	private String date_de_naissance;
	private String role;
	private String email;
	private String mot_de_pasee;
	private boolean enabled;
	private String numero;
	@Transient
	private String token;
  
  public Personne() {
	  
  }
  

public Personne(Long id,double cin,String nom, String prenom, String date_de_naissance,String role,String email, String mot_de_pasee,String numero) {
	super();
	this.cin=cin;
	this.nom = nom;
	this.prenom = prenom;
	this.date_de_naissance = date_de_naissance;
	this.role=role;
	this.email = email;
	this.mot_de_pasee = mot_de_pasee;
	this.id = id;
	this.numero=numero;
	
}


public double getCin() {
	return cin;
}

public void setCin(double cin) {
	this.cin = cin;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}



public String getToken() {
	return token;
}


public void setToken(String token) {
	this.token = token;
}


public String getDate_de_naissance() {
	return date_de_naissance;
}

public void setDate_de_naissance(String date_de_naissance) {
	this.date_de_naissance = date_de_naissance;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMot_de_pasee() {
	return mot_de_pasee;
}

public void setMot_de_pasee(String mot_de_pasee) {
	this.mot_de_pasee = mot_de_pasee;
}

public Long getId() {
	return id;
}

public String getNumero() {
	return numero;
}


public void setNumero(String numero) {
	this.numero = numero;
}


public void setId(Long id) {
	this.id = id;
}


public boolean isEnabled() {
	return enabled;
}


public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}


  
}
