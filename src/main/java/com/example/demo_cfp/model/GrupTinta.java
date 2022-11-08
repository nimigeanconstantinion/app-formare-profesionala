package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name = "GrupTinta")
@Table(name = "gruptinta")

public class GrupTinta {
    @Id
    @SequenceGenerator(name = "gruptinta_seq",sequenceName = "gruptinta_seq",allocationSize = 1)
    private long id;

    private String codGrTinta;
    private String grupTinta;

}
