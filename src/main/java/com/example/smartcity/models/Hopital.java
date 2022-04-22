package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class Hopital extends Administartion {
    private EAdministrationType type=EAdministrationType.Hopital;
    private String gouvernerat;
}