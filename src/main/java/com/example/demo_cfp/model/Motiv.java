package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name="Motiv")
@Table(name="motiv")

public class Motiv {
    @Id
    @Column(unique = true)
    private int codMotiv;

    private String motiv;
    private boolean imputabil;

    public boolean equals(Object m){
        return this.codMotiv==((Motiv) m).getCodMotiv();
    }


}
