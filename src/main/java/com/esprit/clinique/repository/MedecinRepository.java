package com.esprit.clinique.repository;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
