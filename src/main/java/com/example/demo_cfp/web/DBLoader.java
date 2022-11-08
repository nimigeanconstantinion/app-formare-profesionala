package com.example.demo_cfp.web;

import com.example.demo_cfp.model.CorNomenclator;
import com.example.demo_cfp.model.Cursant;
import com.example.demo_cfp.model.StareCursantNom;
import com.example.demo_cfp.repository.CorNomenclatorRepo;
import com.example.demo_cfp.repository.CursantRepo;
import com.example.demo_cfp.repository.StareNomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cfp")
@CrossOrigin
public class DBLoader {
    private CorNomenclatorRepo corNomenclatorRepo;
    private CursantRepo cursantRepo;
    private StareNomRepository stareNomRepository;
    @Autowired
    public DBLoader(CorNomenclatorRepo corNomenclatorRepo,
                    CursantRepo cursantRepo,StareNomRepository stareNomRepository){
        this.cursantRepo=cursantRepo;
        this.corNomenclatorRepo=corNomenclatorRepo;
        this.stareNomRepository=stareNomRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/cor")
    public List<CorNomenclator> addAllCor(@RequestBody List<CorNomenclator> cor){
        for (CorNomenclator c:cor
             ) {
            corNomenclatorRepo.save(c);
        }
        return cor;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/addcursanti")
    public List<Cursant> addAllCursanti(@RequestBody List<Cursant> crs){
        for (Cursant c:crs
        ) {
            cursantRepo.save(c);
        }
        return crs;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nomstari")
    public List<StareCursantNom> getNomStari(){
       return stareNomRepository.findAll();
    }

}
