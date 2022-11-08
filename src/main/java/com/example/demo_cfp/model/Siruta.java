package com.example.demo_cfp.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name="Siruta")
@Table(name = "siruta")

public class Siruta {
    @Id
    @Column(name = "SIRUTA",unique=true,columnDefinition = "varchar(6)")
    private String siruta;

//    @OneToOne(mappedBy = "locainf")
//    private Cursant cursant;
    private String sirutasup;
    private String tip,denumireLocalitate,judet;

}
