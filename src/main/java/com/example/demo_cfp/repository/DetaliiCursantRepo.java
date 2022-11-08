package com.example.demo_cfp.repository;

import com.example.demo_cfp.model.DetaliiCursant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DetaliiCursantRepo extends JpaRepository<DetaliiCursant,Long> {
    @Query("select d from DetaliiCursant d where d.cnp=?1 order by d.id asc")
    List<DetaliiCursant> findAllByCnp(String cnp);

    @Query("select d from DetaliiCursant d where d.idCurs=?1 order by d.cursant.nume desc ,d.cursant.prenume")
    List<DetaliiCursant> findAllByIdCurs(Integer idCurs);

    @Query("select d from DetaliiCursant d left join Curs c on d.idCurs=c.id where d.cnp=?1 order by c.dataStart asc ")
    List<DetaliiCursant> findAllByCnpDataCurs(String cnp);

//    @Query(value = "select a.cnp,a.nume,b.data_detaliu,d.* from cfp_db.cursant a join cfp_db.detaliicursant b on b.cnp=a.cnp left join cfp_db.curs c on b.id_curs=c.id left join cfp_db.cornomenclator d on d.cod_cor_nom=c.fk_cod_cor_nom where a.cnp='2760530335007'",nativeQuery = true)
//    List<Object[]> getDetaByCnp(String cnp);
    @Query("select a.cnp,a.nume,b.dataDetaliu,d from Cursant a join DetaliiCursant b on b.cnp=a.cnp left join Curs c on b.idCurs=c.id left join CorNomenclator d on d.codCorNom=c.corNomenclator where a.cnp=?1")
    List<Object[]> getDetaByCnp(String cnp);

    @Query("select d from DetaliiCursant d where d.cnp=?1 and d.idCurs=?2")
    Optional<DetaliiCursant> getDetaliiCursantByIdCursAndCnp(String cnp,Integer idCurs);

    @Query("select d from DetaliiCursant d where id=?1")
    Optional<DetaliiCursant> findDetaliiCursantByIdDetaliu(long id);
}
