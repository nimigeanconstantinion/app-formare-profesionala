package com.example.demo_cfp.services;

import com.example.demo_cfp.model.Cursant;
import com.example.demo_cfp.model.DetaliiCursant;
import com.example.demo_cfp.repository.DetaliiCursantRepo;
import com.example.demo_cfp.repository.StareRepository;
import com.sun.jdi.InvalidLineNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetaliiCursantServices {
    DetaliiCursantRepo detaliiCursantRepo;
    StareRepository stareRepository;
    @Autowired
    public DetaliiCursantServices(DetaliiCursantRepo detaliiCursantRepo,StareRepository stareRepository){
        this.detaliiCursantRepo=detaliiCursantRepo;
        this.stareRepository=stareRepository;
    }

    public void addDetaliuCursant(DetaliiCursant dt) throws RuntimeException{
        List<DetaliiCursant> lista=detaliiCursantRepo.findAllByCnp(dt.getCnp());
        if(lista.stream().filter(d->d.equals(dt)).collect(Collectors.toList()).size()==0){
            detaliiCursantRepo.save(dt);
        }else{
            throw new RuntimeException("Cursantul exista deja la cursul selectat!!");
        }
    }

    public void updateDet(DetaliiCursant dt){
        detaliiCursantRepo.save(dt);

    }


    public void updDetaliuCursant(DetaliiCursant dt){
        List<DetaliiCursant> lista=detaliiCursantRepo.findAllByCnp(dt.getCnp());
        if(lista.stream().filter(d->d.equals(dt)).collect(Collectors.toList()).size()==1){
            detaliiCursantRepo.save(dt);
        }else{
            throw new RuntimeException("Cursantul nu exista la cursul selectat!!");
        }
    }

    public DetaliiCursant getDetById(long id) throws RuntimeException{
        Optional<DetaliiCursant> odt=detaliiCursantRepo.findDetaliiCursantByIdDetaliu(id);
        if(odt.isPresent()){
            return odt.get();
        }else{
            throw new RuntimeException("Nu exista detaliu cu id-ul specificat");
        }
    }

    public void removeDetaliuCursant(DetaliiCursant dt) throws RuntimeException{
        List<DetaliiCursant> lista=detaliiCursantRepo.findAllByCnp(dt.getCnp());
        if(lista.stream().filter(d->d.equals(dt)).collect(Collectors.toList()).size()==1){
            detaliiCursantRepo.delete(dt);
        }else{
            throw new RuntimeException("Cursantul nu exista la cursul selectat!!");
        }
    }

    public DetaliiCursant isCursant(String cnp, int idCurs){
        Optional<DetaliiCursant> det=detaliiCursantRepo.getDetaliiCursantByIdCursAndCnp(cnp,idCurs);
        if(det.isPresent()){
            return det.get();
        }else{
            return null;
        }
    }
}
