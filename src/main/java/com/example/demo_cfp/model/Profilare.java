package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "Profilare")
@Table(name="profilare")

public class Profilare {
    @Id
    @SequenceGenerator(name = "profilare_seq",sequenceName = "profolare_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profolare_seq")
    private long id;

    private String codProfil;
    private String denProfil;

}
