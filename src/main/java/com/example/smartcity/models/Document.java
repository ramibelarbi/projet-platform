package com.example.smartcity.models;


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
    private Administartion organisation;
    @ManyToOne
    private Personne citoyen;
    @Transient
    private MultipartFile file ;
}
