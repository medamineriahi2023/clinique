package com.esprit.clinique.repository;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
