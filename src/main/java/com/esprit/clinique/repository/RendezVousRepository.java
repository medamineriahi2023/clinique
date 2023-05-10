package com.esprit.clinique.repository;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.RendezVous;
import com.esprit.clinique.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    List<RendezVous> findByMedecinCliniquesIdAndMedecinSpecialite(Long cliniqueId, Specialite specialite);

    int countRendezVousByMedecin_Id(Long id);
}
