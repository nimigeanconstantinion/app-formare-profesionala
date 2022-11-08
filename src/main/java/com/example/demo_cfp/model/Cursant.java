package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "Cursant")
@Table(name = "cursant")

public class Cursant extends Persoana{
    private String prenTata;
    private String prenMama;
    private String locNastere;
    private String judNastere;
    private String taraNastere;

    @Column(name = "cnp",unique = true,columnDefinition = "VARCHAR(13)")
    private String cnp;
    private String nume;
    private String prenume;

//    @OneToMany(targetEntity = DetaliiCursant.class)
//    @JoinColumn(name = "cnp",referencedColumnName = "cnp")
//    private List<DetaliiCursant> detalii;

//    @OneToOne(targetEntity =Siruta.class)
//    @JoinColumn(name = "lo_code",referencedColumnName = "siruta")
//    private Siruta locaInf;
//
//    private String locaSup;
//    private String judDomiciliu;
//
//    private String blCasa;
//    private String nrBl;
//
//    private String scara;
//    private String etaj;
//    private String apart;
//
//    private String telefon;
//    private String email;
//
//    private String numarCurs;
//
//    @OneToMany
//    @JoinColumn(name = "detalii",)

    public Cursant(String cnp){
        super();
        this.cnp=cnp;
    }

    public Cursant(String cnp, String nume, String prenume,String prenTata, String prenMama) {
        super();
        this.prenTata = prenTata;
        this.prenMama = prenMama;
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
    }

    public boolean equals(Object o){
        Cursant c=(Cursant) o;
        return (this.cnp.equals(((Cursant) o).getCnp()));
    }
}
