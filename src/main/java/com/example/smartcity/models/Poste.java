package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class Poste extends Administartion{
    private EAdministrationType type=EAdministrationType.Poste;
    private String gouvernerat;
    private String ville;
}

