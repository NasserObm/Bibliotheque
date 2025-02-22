package com.bibliotheque.services.interfaces;

import com.bibliotheque.models.dtos.requests.RegisterRequest;
import com.bibliotheque.models.dtos.responses.RegisterResponse;
import com.bibliotheque.models.entities.Utilisateur;

import java.util.UUID;

public interface UtilisateurService {
   void register(Utilisateur utilisateur);
   void deleteUtilisateur(Long id);
}
