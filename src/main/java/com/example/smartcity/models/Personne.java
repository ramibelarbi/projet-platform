package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity @Table(name = "personne")
@Getter @Setter @NoArgsConstructor
public class Personne implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String cin;
    private String password;
    private String nom;
    private String prenom;
    private Role role;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateNaissance;
    @OneToOne
    private Adresse adresse;
}
