package com.smartcity.main.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Autorisation {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "requested_autorisation_id")
    private  User requestedAutorisation;

   @ManyToOne
   @JoinColumn(name = "document_id")
   private Document document;

    private Date dateDemandeAcces ;

    private Date dateReponse;

    private boolean accepted;


    public Autorisation( User requestedAutorisation, Document document, Date dateDemandeAcces, Date dateReponse, boolean accepted) {
        this.requestedAutorisation = requestedAutorisation;
        this.document = document;
        this.dateDemandeAcces = dateDemandeAcces;
        this.dateReponse = dateReponse;
        this.accepted = accepted;
    }


}
