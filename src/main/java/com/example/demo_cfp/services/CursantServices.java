package com.example.demo_cfp.services;

import com.example.demo_cfp.model.Cursant;
import com.example.demo_cfp.repository.CursantRepo;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CursantServices {
@Autowired
    private CursantRepo cursantRepo;
    private LocalDateTime lt;
    public boolean isCursant(String cnp){
        Optional<Cursant> c=cursantRepo.findCursantByCnp(cnp);
        if(c.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public boolean validCNP(String p_cnp){
        int i=0,year=0,hashResult = 0;
        ArrayList<Integer> cnp=new ArrayList<>();
        for(i=0;i<p_cnp.length();i++){
            cnp.add(Integer.parseInt(p_cnp.substring(i,i+1)));
        }
        ArrayList<Integer> hashTable= new ArrayList(List.of(2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9));
        if (p_cnp.length() != 13) {
            return false;
        }


        for (i = 0; i < 13; i++) {

                  //  parseInt(p_cnp.charAt(i), 10);
            if (Double.isNaN(Double.parseDouble(p_cnp.substring(i)))) {
                return false;
            }
            if (i < 12) {
                hashResult = hashResult + (cnp.get(i) * hashTable.get(i));
            }
        }
        hashResult = hashResult % 11;
        if (hashResult == 10) {
            hashResult = 1;
        }
        year = (cnp.get(1) * 10) + cnp.get(2);

        switch (cnp.get(0)){
            case 1:
            case 2:
                year += 1900;
                break;
            case 3  :
            case 4 : {
                year += 1800;
            }
            break;
            case 5  :
            case 6 : {
                year += 2000;
            }
            break;
            case 7  :
            case 8 :
            case 9 : {
                year += 2000;
                if (year > LocalDateTime.now().getYear() - 14) {
                    //,
                    //      parseInt(new Date().getYear(), 10) - 14)) {
                    year -= 100;
                }
            }
            break;
            default : {
                return false;
            }

        }
        if (year < 1800 || year > 2099) {
            return false;
        }
        return (cnp.get(12) == hashResult);

    }

    public Cursant addCursant(Cursant c) throws RuntimeException{
        boolean vcnp=validCNP(c.getCnp());
//        boolean ispers=isCursant(c.getCnp());
            if (!vcnp) {
                throw new RuntimeException("Nu este bun CNP!!!");
            }else {
                cursantRepo.save(c);
                return c;
            }
    }

}
