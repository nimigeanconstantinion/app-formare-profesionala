package com.example.demo_cfp.web;

import com.example.demo_cfp.model.Curs;
import com.example.demo_cfp.model.Cursant;
import com.example.demo_cfp.model.DetaliiCursant;
import com.example.demo_cfp.model.Siruta;
import com.example.demo_cfp.services.CursServices;
import com.example.demo_cfp.services.CursantServices;
import com.example.demo_cfp.services.DetaliiCursantServices;
import com.example.demo_cfp.services.SirutaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cfp")
@CrossOrigin
public class AppController {

    private CursServices cursServices;
    private SirutaServices sirutaServices;
    private CursantServices cursantServices;
    private DetaliiCursantServices detaliiCursantServices;

    @Autowired
    public AppController(CursServices cursServices,
                         SirutaServices sirutaServices,
                         CursantServices cursantServices,
                         DetaliiCursantServices detaliiCursantServices){
        this.cursServices=cursServices;
        this.sirutaServices=sirutaServices;
        this.cursantServices=cursantServices;
        this.detaliiCursantServices=detaliiCursantServices;
    }
//Todo: GET Functions

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cursuri")
    public List<Curs> getAllCursuri(){
        return cursServices.getAllCursuri();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/siruta")
    public List<Siruta> getAllSiruta(){
        return sirutaServices.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/siruta/{jud}")
    public List<Siruta> getAllByJudet(@PathVariable String jud){
        return sirutaServices.getSirutaByJudet(jud);
    }


//Todo: Adaugare

    @ResponseStatus(HttpStatus.OK)
    @PostMapping ("/addcursant")
    public Cursant addCursant(@RequestBody Cursant c){
        cursantServices.addCursant(c);
        return c;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping ("/addDetaliu")
    public DetaliiCursant addDetaliuCursant(@RequestBody DetaliiCursant dt){
        detaliiCursantServices.addDetaliuCursant(dt);
        return dt;
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping ("/updDetaliu")
    public DetaliiCursant updDetaliuCursant(@RequestBody DetaliiCursant dt){
        detaliiCursantServices.updDetaliuCursant(dt);
        return dt;
    }

}
