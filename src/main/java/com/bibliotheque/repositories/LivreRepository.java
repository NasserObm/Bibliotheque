package com.bibliotheque.repositories;

import com.bibliotheque.models.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {}

