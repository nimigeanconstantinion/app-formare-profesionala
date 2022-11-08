package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.Cursant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursantRepo extends JpaRepository<Cursant,String> {

    @Query("select c from Cursant c where c.cnp=?1")
    Optional<Cursant> findCursantByCnp(String cnp);
}
