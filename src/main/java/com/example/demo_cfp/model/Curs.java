package com.example.demo_cfp.model;

import lombok.*;
import net.bytebuddy.description.type.TypeList;
import org.hibernate.annotations.FetchProfiles;
import org.hibernate.annotations.GeneratorType;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name="Curs")
@Table(name="curs")

public class Curs {
    @Id
//    @SequenceGenerator(name="curs_seq",sequenceName = "curs_seq",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "curs_seq")
    private int id;

//    @Column(name = "numarCurs",unique = true)
//    private int numarCurs;

    @Column(columnDefinition = "varchar(20) default ''")
    private String tipCurs;

    @Column(columnDefinition = "varchar(20) default ''")
    private String idFurnizor;

    @OneToOne(targetEntity = Autorizatie.class)

    @JoinColumn(name="fk_autorizatie",referencedColumnName = "id")
    private Autorizatie autorizatie;

    private LocalDate dataStart;
    private LocalDate dataSfarsit;
    private LocalDate dataExamen;
    private String nivel;

    @OneToOne(targetEntity = CorNomenclator.class)
    @JoinColumn(name = "fk_codCorNom",referencedColumnName ="codCorNom")

    private CorNomenclator corNomenclator;
    @Column(columnDefinition = "varchar(256) default ''")
    private String denumireCalifOcup;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="idCurs",nullable=false)
    private List<DetaliiCursant> cursanti;


    @Transactional
    public void addDetail(DetaliiCursant dt){
        dt.setIdCurs((int)id);
        this.cursanti.add(dt);
    }

    @Transactional
    public void removeDetail(DetaliiCursant dt){
        this.cursanti.remove(dt);
    }

}
