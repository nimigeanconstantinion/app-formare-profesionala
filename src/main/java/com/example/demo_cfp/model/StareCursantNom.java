package com.example.demo_cfp.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "StareCursantNom")
@Table(name = "stareursantnom")
public class StareCursantNom {
    @Id
    @SequenceGenerator(name = "stare_seq",sequenceName = "stare_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stare_seq")
    private long id;

    private String codStare;
    private String stare;
    private int impNeimp;

}
