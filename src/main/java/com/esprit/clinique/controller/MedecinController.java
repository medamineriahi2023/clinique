package com.esprit.clinique.controller;

import com.esprit.clinique.entities.Medecin;
import com.esprit.clinique.service.interfaces.IMedicinService;
import com.esprit.clinique.service.interfaces.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/medecin")
public class MedecinController {
    @Autowired
    private IMedicinService iMedicinService;

    @Autowired
    private IRendezVousService iRendezVousService;

    @PostMapping
    public Medecin save(@RequestBody Medecin medecin){
        return iMedicinService.save(medecin);
    }


    @GetMapping
    public List<Medecin> getAll(){
        return iMedicinService.getALl();
    }


    @PutMapping
    public Medecin update(@RequestBody Medecin medecin){
        return iMedicinService.update(medecin);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        iMedicinService.delete(id);
    }

    @GetMapping("/calcul/{idMedecin}/{startDate}/{endDate}")
    public String getRevenuMedecin (
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate

    ){
        return iRendezVousService.calcul(idMedecin, startDate, endDate);
    }


}
