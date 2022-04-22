package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class GardeNational extends Administartion {
    private EAdministrationType type=EAdministrationType.Garde_National;
    private String gouvernerat;
    private String ville;
}

