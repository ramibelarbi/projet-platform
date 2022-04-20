package com.smartcity.main.model;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Document {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private String type;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;


    @ManyToOne
    @JoinColumn(name = "citoyen_id")
    private User citoyen;


    @Transient
    private MultipartFile file ;
}
