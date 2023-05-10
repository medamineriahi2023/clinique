package com.esprit.clinique.controller;

import com.esprit.clinique.entities.RendezVous;
import com.esprit.clinique.entities.Specialite;
import com.esprit.clinique.service.interfaces.IRendezVousService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rendez-vous")
@RequiredArgsConstructor
public class RendezVousController {
    private final IRendezVousService rendezVousService;

    @PostMapping
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous){
        return rendezVousService.save(rendezVous);
    }

    @GetMapping
    public List<RendezVous> getAll(){
        return rendezVousService.getALl();
    }

    @PutMapping("/addAndAssign/{idMed}/{idPatient}")
    public void addAndAssign(@RequestBody RendezVous rendezVous ,@PathVariable Long idMed , @PathVariable Long idPatient){
         rendezVousService.addRDVAndAssignMedAndPatient(rendezVous, idMed, idPatient);
    }

    @GetMapping("/getListRdv/{idClinique}/{specialite}")
    public List<RendezVous> addAndAssign(@PathVariable Long idClinique , @PathVariable Specialite specialite){
        return rendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("/count/{idMed}")
    public int addAndAssign(@PathVariable Long idMed ){
        return rendezVousService.getNbrRendezVousMedecin(idMed);
    }


}
