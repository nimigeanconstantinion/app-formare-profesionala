package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.StareCursant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StareRepository extends JpaRepository<StareCursant,Long> {

}
