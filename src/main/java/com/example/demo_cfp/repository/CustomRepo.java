package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.Curs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;


public interface CustomRepo {

   public Curs getCursById(Integer codCurs);
}
