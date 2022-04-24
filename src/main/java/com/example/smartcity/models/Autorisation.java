package com.example.smartcity.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Autorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private  Personne requestedAutorisation;
   @ManyToOne
   private Document document;
    private Date dateDemandeAcces ;
    private Date dateReponse;
    private boolean accepted;
    public Autorisation(Personne requestedAutorisation, Document document, Date dateDemandeAcces, Date dateReponse, boolean accepted) {
        this.requestedAutorisation = requestedAutorisation;
        this.document = document;
        this.dateDemandeAcces = dateDemandeAcces;
        this.dateReponse = dateReponse;
        this.accepted = accepted;
    }
}
