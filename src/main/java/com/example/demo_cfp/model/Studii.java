package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "Studii")
@Table(name = "studii")
public class Studii {
    @Id
    private int cod;

    private String studii;
    private String isced;
}
