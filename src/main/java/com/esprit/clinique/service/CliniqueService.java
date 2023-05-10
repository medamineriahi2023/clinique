package com.esprit.clinique.service;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.Medecin;
import com.esprit.clinique.repository.CliniqueRepository;
import com.esprit.clinique.repository.MedecinRepository;
import com.esprit.clinique.service.interfaces.ICliniqueService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CliniqueService implements ICliniqueService {


    private final CliniqueRepository cliniqueRepository;
    private final MedecinRepository medecinRepository;
    @Override
    public Clinique save(Clinique entity) {
        return cliniqueRepository.save(entity);
    }

    @Override
    public List<Clinique> getALl() {
        return cliniqueRepository.findAll();
    }

    @Override
    public Clinique update(Clinique entity) {
        return cliniqueRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
cliniqueRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
        Assert.notNull(clinique, "id not found");
        Assert.notNull(medecin, "medecin ne doit pas etre null");
        medecinRepository.saveAndFlush(medecin);
        clinique.getMedecins().add(medecin);
        return medecin;
    }
}
