package com.example.demo_cfp.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "Autorizatie")
@Table(name = "autorizatie")

public class Autorizatie {
    @Id
    @SequenceGenerator(name = "autorizatie_seq",sequenceName = "autorizatie_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "autorizatie_seq")
    private long id;

    @NaturalId
    @Column(name="nrAutorizatie",nullable = false,updatable = false,unique = true,columnDefinition = "varchar(50)")
    private String nrAutorizatie;

    private LocalDate dataAutorizatie;
    private String nrRNFPA;
    private LocalDate dataRNFPA;

    @OneToOne(targetEntity = CorNomenclator.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name="corNom",referencedColumnName = "codCorNom")
    private CorNomenclator codFormare;

    private String tipCertificat;
    private String tipAutorizatie;

    private int oreTotal=0,orePractica=0,oreTeorie=0;
    private String bazaLegala;
    private String condAcces;
    private String notare;
    private String nivel;

    private String competenta1;
    private String competenta2;
    private String competenta3;
    private String competenta4;
    private String competenta5;
    private String competenta6;
    private String competenta7;
    private String competenta8;
    private String competenta9;
    private String competenta10;
    private String competenta11;
    private String competenta12;
    private String competenta13;
    private String competenta14;
    private String competenta15;
    private String competenta16;
    private String competenta17;
    private String competenta18;
    private String competenta19;
    private String competenta20;
    private String competenta21;
    private String competenta22;
    private String competenta23;
    private String competenta24;
    private String competenta25;
    private String competenta26;
    private String competenta27;


    public boolean equals(Object o){
        Autorizatie a=(Autorizatie) o;
        return this.nrAutorizatie.equals(a.getNrAutorizatie())&&this.dataAutorizatie.compareTo(a.getDataAutorizatie())==0;
    }
}
