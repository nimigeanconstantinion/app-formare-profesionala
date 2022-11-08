package com.example.demo_cfp.services;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.example.demo_cfp.model.Siruta;
import com.example.demo_cfp.repository.SirutaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SirutaServices {
   // private MyRepo myRepo;
    @PersistenceContext
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

//    private EntityManagerFactory entityManagerFactory;
//    private CriteriaBuilder cb;
 //   private CriteriaBuilderFactory cbf;

    @Autowired
    private SirutaRepo sirutaRepo;


    public SirutaServices(SirutaRepo sirutaRepo){
        this.sirutaRepo=sirutaRepo;

    }

    public List<Siruta> getAll(){
        return sirutaRepo.findAll();
    }

    public void loadAll(List<Siruta> sirutas){
            sirutaRepo.saveAll(sirutas);
    }

    public List<Siruta> getSiruta(String localitate,String judet){
        return sirutaRepo.getSirutaByLoca(localitate,judet);
    }

    public List<Siruta> newGetAll(){
        List st=new ArrayList<>();
        st=null;

        //        return entityManager.createQuery("""
//            select s from Siruta s
//            """).unwrap(org.hibernate.query.Query.class)
//                .getResultList();
        System.out.println("Inainte de cbf");
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        CriteriaBuilderFactory cbf = config.createCriteriaBuilderFactory(entityManagerFactory);

        System.out.println("Dupa cb factory");
        //
//
//        st=cbf.create(entityManager,Siruta.class).from(Siruta.class,"srt").getResultList();
//        System.out.println(st);
        return st;
//        return cbf.create(entityManager,Siruta.class)
//                .from(Siruta.class,"st").getResultList();
    }

    //test
//    public Siruta findSiruta(Long id){
//
//        return (Siruta) myRepo.findById(id).get();
//
//    }

    public List<Siruta> getSirutaByLocalitateAndJudet(String loca,String jud){
        List<Siruta> p=sirutaRepo.findAll();
        if(p.size()>0){
            List<Siruta> s=p.stream().filter(l->l.getDenumireLocalitate().toUpperCase().contains(loca.toUpperCase())&&l.getJudet()==jud).collect(Collectors.toList());
            return s;
        }else {
            return null;
        }
    }

    public List<Siruta> getSirutaByJudet(String judet){
        return sirutaRepo.getSirutaByJudet(judet);
    }

    public List<Object[]> getSirutaAndLocaSupBySiruta(String siruta){

        return sirutaRepo.getSirutaSirutaSupBySiruta(siruta);
    }
}
