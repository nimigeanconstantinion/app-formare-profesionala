package com.example.demo_cfp.web;

import com.example.demo_cfp.model.*;
import com.example.demo_cfp.repository.*;
import com.example.demo_cfp.services.CursServices;
import com.example.demo_cfp.services.CursantServices;
import com.example.demo_cfp.services.DetaliiCursantServices;
import com.example.demo_cfp.services.SirutaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cfp")
@CrossOrigin
public class SirutaController {

    SirutaServices sirutaServices;
    CursantRepo cursantRepo;
    CursRepo cursRepo;
    CursServices cursServices;
    CursantServices cursantServices;
    DetaliiCursantServices detaliiCursantServices;
    TestRepo testRepo;
    DetaliiCursantRepo detaliiCursantRepo;
    StareNomRepository stareNomRepository;
    List<Siruta> localitati=new ArrayList<>();

    @Autowired
    public SirutaController(SirutaServices sirutaServices,
                            CursantRepo cursantRepo,
                            CursRepo cursRepo,
                            DetaliiCursantRepo detaliiCursantRepo,
                            TestRepo testRepo,
                            CursServices cursServices,
                            DetaliiCursantServices detaliiCursantServices,
                            CursantServices cursantServices,
                            StareNomRepository stareNomRepository) {
        this.sirutaServices = sirutaServices;
        this.cursantRepo=cursantRepo;
        this.cursRepo=cursRepo;
        this.detaliiCursantRepo=detaliiCursantRepo;
        this.testRepo=testRepo;
        this.cursServices=cursServices;
        this.detaliiCursantServices=detaliiCursantServices;
        this.cursantServices=cursantServices;
        this.stareNomRepository=stareNomRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Siruta> getLoca(){
        return sirutaServices.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{loca}/{jud}")
    public List<Siruta> getLoca(@PathVariable String loca,@PathVariable String jud){
        return sirutaServices.getSiruta(loca,jud);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/siruta/{loca}/{jud}")
    public List<Siruta> getSirutaLocalitateJudet(@PathVariable String loca,@PathVariable String jud){
        return sirutaServices.getSiruta(loca,jud);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/siruta_lj/{loca}/{jud}")
    public List<Siruta> getSirutaLocaJud(@PathVariable String loca,@PathVariable String jud){
        return sirutaServices.getSirutaByLocalitateAndJudet(loca,jud);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cursanti")
    public List<Cursant> getAll(){
        return cursantRepo.findAll();
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/cursuri")
//    public List<Curs> getCursuri(){
//        return cursRepo.findAll();
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/curs_id/{idCurs}")
    public Curs getCursByID(@PathVariable Long idCurs){
       return cursServices.getCourseByID(idCurs);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detaliicursant")
    public List<DetaliiCursant> getAllDetalii(){
        return detaliiCursantRepo.findAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/addloca")
    public List<Siruta> addLoca(@RequestBody Siruta siruta){
        siruta.setSiruta("100");
       // sirutaRepo.save(siruta);
       // return sirutaRepo.findAll();
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/addtest")
    public Test addTest(@RequestBody Test test){
        testRepo.save(test);
        return test;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/batchAdd")
    public List<Siruta> addAllLoca(@RequestBody List<Siruta> siruta){
            sirutaServices.loadAll(siruta);

            return siruta;
    }

    //testquerry
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test1/{idC}")
    public List<DetaliiCursant> getDetByIdCurs(@PathVariable Integer idC){
        return detaliiCursantRepo.findAllByIdCurs(idC);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test2/{pcnp}")
    public List<DetaliiCursant> getDetByCNPDataCurs(@PathVariable String pcnp){
        return detaliiCursantRepo.findAllByCnpDataCurs(pcnp);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test3/{pcnp}")
    public Object getX(@PathVariable String pcnp){
        List<Object[]> a=detaliiCursantRepo.getDetaByCnp(pcnp);
        return a.get(0);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test4/{siruta}")
    public List<Object[]> getLocaSup(@PathVariable String siruta){
        return sirutaServices.getSirutaAndLocaSupBySiruta(siruta);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test5/{cnp}/{idCurs}")
    public DetaliiCursant getDetCursantbyCNPIDcurs(@PathVariable String cnp,@PathVariable Integer idCurs){
        return detaliiCursantServices.isCursant(cnp,idCurs);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/test6/{idDetaliu}")
    public void removeDetaliuById(@PathVariable long idDetaliu){
        detaliiCursantServices.removeDetaliuCursant(detaliiCursantServices.getDetById(idDetaliu));

    }



//    @ResponseStatus(HttpStatus.OK)
//    @PostMapping ("/addcursant")
//    public Cursant addCursant(@RequestBody Cursant c){
//        cursantServices.addCursant(c);
//        return c;
//    }
}

