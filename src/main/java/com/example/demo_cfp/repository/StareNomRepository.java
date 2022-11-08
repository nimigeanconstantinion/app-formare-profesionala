package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.StareCursantNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StareNomRepository extends JpaRepository<StareCursantNom,Long>{

}
