package com.example.demo_cfp.services;

import com.example.demo_cfp.exceptions.CursNegasit;
import com.example.demo_cfp.model.Curs;
import com.example.demo_cfp.repository.CursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursServices {
    @Autowired
    private CursRepo cursRepo;

    public CursServices(CursRepo cursRepo){
        this.cursRepo=cursRepo;
    }

    public Curs getCourseByID(Long idC){
        if(cursRepo.findById(idC).isPresent()){
            return cursRepo.findById(idC).get();
        }else{
            throw new CursNegasit("Cursul nu exista in BD");
        }

    }

    public List<Curs> getAllCursuri(){
        return cursRepo.findAll();
    }

}
