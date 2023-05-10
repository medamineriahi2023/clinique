package com.esprit.clinique.service;

import com.esprit.clinique.entities.Patient;
import com.esprit.clinique.repository.PatientRepository;
import com.esprit.clinique.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {


    private final PatientRepository patientRepository;

    @Override
    public Patient save(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public List<Patient> getALl() {
        return patientRepository.findAll();
    }

    @Override
    public Patient update(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
