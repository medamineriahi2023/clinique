package com.esprit.clinique.controller;

import com.esprit.clinique.entities.Patient;
import com.esprit.clinique.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService iPatientService;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return iPatientService.save(patient);
    }

    @GetMapping
    public List<Patient> getAll(){
        return iPatientService.getALl();
    }


}
