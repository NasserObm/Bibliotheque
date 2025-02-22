package com.bibliotheque.repositories;

import com.bibliotheque.models.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {
}
