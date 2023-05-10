package com.esprit.clinique.service.interfaces;

import com.esprit.clinique.entities.Clinique;
import com.esprit.clinique.entities.Medecin;

public interface ICliniqueService extends ICrudService<Clinique>{

    Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);

}

