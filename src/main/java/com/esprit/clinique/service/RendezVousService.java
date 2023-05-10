package com.esprit.clinique.service;

import com.esprit.clinique.entities.*;
import com.esprit.clinique.repository.MedecinRepository;
import com.esprit.clinique.repository.PatientRepository;
import com.esprit.clinique.repository.RendezVousRepository;
import com.esprit.clinique.service.interfaces.ICrudService;
import com.esprit.clinique.service.interfaces.IRendezVousService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService implements IRendezVousService {

    private final RendezVousRepository rendezVousRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;

    @Override
    public RendezVous save(RendezVous entity) {
        return rendezVousRepository.save(entity);
    }

    @Override
    public List<RendezVous> getALl() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous update(RendezVous entity) {
        return rendezVousRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        Assert.notNull(medecin, "Medecin not found");
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        Assert.notNull(patient, "Patient not found");
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rendezVousRepository.saveAndFlush(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepository.findByMedecinCliniquesIdAndMedecinSpecialite(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepository.countRendezVousByMedecin_Id(idMedecin);
    }
}
