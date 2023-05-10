package com.esprit.clinique.repository;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.RendezVous;
import com.esprit.clinique.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    List<RendezVous> findByMedecinCliniquesIdAndMedecinSpecialite(Long cliniqueId, Specialite specialite);

    int countRendezVousByMedecin_Id(Long id);

    List<RendezVous> findByDateRdvBefore(Date date);

    List<RendezVous> findByMedecin_IdAndDateRdvBetween(Long id ,Date startDate, Date endDate);
}
