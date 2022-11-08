package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name="CorNomenclator")
@Table(name = "cornomenclator")

public class CorNomenclator {
//    @Id
//    @SequenceGenerator(name="cornomenclator_seq",
//            sequenceName = "cornomenclator_seq",
//            allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "cornomenclator_seq")
//    private long id;

    @Id
    @Column(name="codCorNom",unique=true,columnDefinition = "varchar(20)")
    private String codCorNom;

    private String denCorNom;

    public boolean equals(Object o){
        return this.codCorNom.equals(((CorNomenclator) o).getCodCorNom());
    }
}
