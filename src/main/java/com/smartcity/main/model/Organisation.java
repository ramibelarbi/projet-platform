package com.smartcity.main.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table (uniqueConstraints = {@UniqueConstraint(columnNames = "fullName")})
public class Organisation {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;



}
