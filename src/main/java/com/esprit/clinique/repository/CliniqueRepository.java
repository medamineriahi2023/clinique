package com.esprit.clinique.repository;

import com.esprit.clinique.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
