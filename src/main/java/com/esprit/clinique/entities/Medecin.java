package com.esprit.clinique.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private Long telephone;

    private Integer prix;

    @JsonIgnore
    @ManyToMany(mappedBy = "medecins")
    private List<Clinique> cliniques;

    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;


}
