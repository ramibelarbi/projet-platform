package com.example.smartcity.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Administartion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private EAdministrationType type;
    @OneToOne
    private Personne Administrateur;
    @OneToMany
    private List<Personne> employes;

}