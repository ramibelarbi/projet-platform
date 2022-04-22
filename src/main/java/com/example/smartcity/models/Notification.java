package com.example.smartcity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity@NoArgsConstructor@Getter@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Personne personne;
    @ManyToOne
    Personne employe;
    @ManyToOne
    Administartion administartion;
    ENotificationType type;
    String text;
}
