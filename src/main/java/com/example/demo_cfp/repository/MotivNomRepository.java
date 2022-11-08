package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.Motiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivNomRepository extends JpaRepository<Motiv,Integer> {
}
