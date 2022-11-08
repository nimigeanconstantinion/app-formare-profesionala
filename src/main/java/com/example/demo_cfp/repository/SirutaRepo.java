package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.Siruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface SirutaRepo extends JpaRepository<Siruta,String> {



    @Query("select s from Siruta s where s.denumireLocalitate LIKE %?1% and s.judet=?2")
    List<Siruta> getSirutaByLoca(String loca, String jud);


    @Query("select s from Siruta s where s.judet=?1 order by s.denumireLocalitate asc ")
    List<Siruta> getSirutaByJudet(String jud);

    @Query("select a,b.denumireLocalitate as locaSup from Siruta a left join Siruta b on a.sirutasup=b.siruta where a.siruta=?1")
    List<Object[]> getSirutaSirutaSupBySiruta(String siruta);
}
