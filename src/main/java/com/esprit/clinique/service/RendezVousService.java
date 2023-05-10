package com.esprit.clinique.service;

import com.esprit.clinique.entities.Medecin;
import com.esprit.clinique.entities.Patient;
import com.esprit.clinique.entities.RendezVous;
import com.esprit.clinique.entities.Specialite;
import com.esprit.clinique.repository.MedecinRepository;
import com.esprit.clinique.repository.PatientRepository;
import com.esprit.clinique.repository.RendezVousRepository;
import com.esprit.clinique.service.interfaces.IRendezVousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public String calcul(Long id ,Date startDate, Date endDate) {

         List<RendezVous> rendezVous = rendezVousRepository.findByMedecin_IdAndDateRdvBetween(id ,startDate,endDate);
         String name = "";
         Integer prix = 0;
            if (!rendezVous.isEmpty()){
                prix = rendezVous.get(0).getMedecin().getPrix();
                name = rendezVous.get(0).getMedecin().getNom();
            }
            return "Le revenu du médecin "+ name +" est = "+ prix * rendezVous.size() + " dt";
    }


    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous(){
       List<RendezVous> rendezVous =  rendezVousRepository.findByDateRdvBefore(new Date());
       rendezVous.forEach(r -> log.info("La liste des rendez-vous : {} : Medecin : {} : Patient : {}",r.getDateRdv(), r.getMedecin().getNom() , r.getPatient().getNom() ));
    }

}
