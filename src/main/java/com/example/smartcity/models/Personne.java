package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

enum Role{
    Administrateur,
    Employe,
    Citoyen
}

@Entity @Table(name = "personne")
@Getter @Setter @NoArgsConstructor
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cin;
    private String nom;
    private String prenom;
    private Role role;
    private Date dateNaissance;
    /*@OneToOne(mappedBy = "adresse")
    private Adresse adresse;*/
}
