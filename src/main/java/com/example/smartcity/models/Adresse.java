package com.example.smartcity.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity @Table(name = "adresse")
public class Adresse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Gouvernerat gouvernerat;
    private String ville;
    private String cite;
    private String rue;
    private int numero;
}
