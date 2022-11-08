package com.example.demo_cfp.web;

import com.example.demo_cfp.model.Motiv;
import com.example.demo_cfp.model.Siruta;
import com.example.demo_cfp.model.StareCursantNom;
import com.example.demo_cfp.repository.MotivNomRepository;
import com.example.demo_cfp.repository.StareNomRepository;
import com.example.demo_cfp.services.SirutaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cfp/utils")
@CrossOrigin
public class UtilsController {
    private MotivNomRepository motivNomRepository;
    private StareNomRepository stareNomRepository;
    private SirutaServices sirutaServices;

    @Autowired
    public UtilsController(MotivNomRepository motivNomRepository,
                           StareNomRepository stareNomRepository,SirutaServices sirutaServices){
        this.motivNomRepository=motivNomRepository;
        this.stareNomRepository=stareNomRepository;
        this.sirutaServices=sirutaServices;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nomenclatormotiv")
    public List<Motiv> getNomenclatorMotiv(){
        return motivNomRepository.findAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nomenclatorStari")
    public List<StareCursantNom> getNomenclatorStari(){
        return stareNomRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sirute")
    public List<Siruta> getSirutes(){
        return sirutaServices.newGetAll();
    }

}
