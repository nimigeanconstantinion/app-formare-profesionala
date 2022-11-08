package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "StareCursant")
@Table(name = "starecursant")

public class StareCursant {
    @Id
    @SequenceGenerator(name = "starecursant_seq",sequenceName = "starecursant_seq",allocationSize = 1)
    private long id;

    private long idCurs;
    private String cnp;
    @OneToOne(targetEntity = StareCursantNom.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "fkStare",referencedColumnName = "id")
    private StareCursantNom starecursant;

    private LocalDate dataStare;
    private String codFiscalAngajator;
    @OneToOne(targetEntity = Motiv.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_motiv",referencedColumnName = "codMotiv")
    private Motiv motiv;

    @Column(updatable = false,insertable = false)
    private int idDet;

}
