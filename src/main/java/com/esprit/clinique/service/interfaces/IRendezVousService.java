package com.esprit.clinique.service.interfaces;

import com.esprit.clinique.entities.RendezVous;
import com.esprit.clinique.entities.Specialite;

import java.util.List;

public interface IRendezVousService extends ICrudService<RendezVous>{

    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);

    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    int getNbrRendezVousMedecin(Long idMedecin);
}
