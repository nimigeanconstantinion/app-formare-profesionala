package com.example.demo_cfp.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name="Test")
@Table(name = "test")

public class Test {
    @Id
    @SequenceGenerator(name="test_seq",sequenceName = "test_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "test_seq")
    private long id;

    private String nume;

}
