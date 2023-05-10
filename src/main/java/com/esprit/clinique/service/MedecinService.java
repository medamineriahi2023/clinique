package com.esprit.clinique.service;

import com.esprit.clinique.entities.Medecin;
import com.esprit.clinique.repository.MedecinRepository;
import com.esprit.clinique.service.interfaces.ICrudService;
import com.esprit.clinique.service.interfaces.IMedicinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinService implements IMedicinService {

    private final MedecinRepository medecinRepository;

    @Override
    public Medecin save(Medecin entity) {
        return medecinRepository.save(entity);
    }

    @Override
    public List<Medecin> getALl() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin update(Medecin entity) {
        return medecinRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        medecinRepository.deleteById(id);

    }
}
