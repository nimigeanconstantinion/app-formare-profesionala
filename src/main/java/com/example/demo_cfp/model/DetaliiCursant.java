package com.example.demo_cfp.model;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "DetaliiCursant")
@Table(name = "detaliicursant")
public class DetaliiCursant {
    @Id
    @SequenceGenerator(name="detcursant_seq",
            sequenceName = "detcursant_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "detcursant_seq"
    )
    private long id;

    private LocalDateTime dataDetaliu;

    @Column(updatable = false,insertable = false)
    private String cnp;


    @OneToOne(targetEntity = Cursant.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cnp",referencedColumnName = "cnp")
    private Cursant cursant;

    @OneToOne(
            targetEntity = Siruta.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "codLocaInf",referencedColumnName = "siruta")
    private Siruta siruta;

    @OneToOne(targetEntity = GrupTinta.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "grupTinta",referencedColumnName = "id")
    private GrupTinta grupTinta;

    @OneToOne(targetEntity = Profilare.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "profil",referencedColumnName = "id")
    private Profilare profilare;

    private String nrsomaj;
    private LocalDate dataStSomaj,dataSfSomaj;

    private String tipCursant;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="idDet",nullable=false)
    private List<StareCursant> stari;

    private String serieCertificat,nrCertificat;

    private float medieCurs,medieExamen;

    @Column(updatable = false,insertable = false)
    private int idCurs;

    private String strada,nrstr,blcas,scara,et,apart,tel,email;

    public DetaliiCursant(String cnp,int idCurs){
        this.cnp=cnp;
        this.idCurs=idCurs;

    }

//    public DetaliiCursant(long id, List<StareCursant> stari, int idCurs) {
//        this.id = id;
//        this.stari = stari;
//        this.idCurs = idCurs;
//    }

    @Transactional
    public void addStare(StareCursant st){
        this.stari.add(st);

    }

    @Transactional
    public void removeStare(StareCursant st){
        this.stari.remove(st);
    }


    public boolean equals(Object o){
        DetaliiCursant dt=(DetaliiCursant) o;
        return this.cnp.equals(dt.getCnp()) && this.idCurs==dt.getIdCurs();
    }

//    @ManyToOne(targetEntity = Curs.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "cdetalii",referencedColumnName = "idCurs")
//    private DetaliiCursant detalii;

}
