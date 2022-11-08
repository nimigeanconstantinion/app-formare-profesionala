package com.example.demo_cfp.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@MappedSuperclass
public class Persoana {
    @Id
    @Column(name = "CNP",unique=true,columnDefinition="VARCHAR(13)")

    private String cnp;

    private String nume;
    private String prenume;

    public boolean equals(Object o){
        Persoana p=(Persoana) o;
        return p.getCnp().equals(this.cnp);
    }

}
