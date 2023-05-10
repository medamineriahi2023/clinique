package com.esprit.clinique.controller;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.Medecin;
import com.esprit.clinique.service.interfaces.ICliniqueService;
import com.esprit.clinique.service.interfaces.IMedicinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clinique")
public class CliniqueController {
    @Autowired
    private ICliniqueService iCliniqueService;

    @PostMapping
    public Clinique addClinique(@RequestBody Clinique clinique){
        return iCliniqueService.save(clinique);
    }

    @GetMapping
    public List<Clinique> getAll(){
        return iCliniqueService.getALl();
    }

    @PutMapping("/addAndAssign/{idClinique}")
    public Medecin addAndAssign(@RequestBody Medecin medecin ,@PathVariable("idClinique") Long id){
        return iCliniqueService.addMedecinAndAssignToClinique(medecin, id);
    }


}
