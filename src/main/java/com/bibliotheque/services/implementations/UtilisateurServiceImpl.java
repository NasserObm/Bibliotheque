package com.bibliotheque.services.implementations;

import com.bibliotheque.mappers.RegisterMapper;
import com.bibliotheque.models.dtos.requests.RegisterRequest;
import com.bibliotheque.models.dtos.responses.RegisterResponse;
import com.bibliotheque.models.entities.Utilisateur;
import com.bibliotheque.repositories.UtilisateurRepository;
import com.bibliotheque.services.interfaces.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    public final RegisterMapper registerMapper;
    public final UtilisateurRepository utilisateurRepository;

    @Override
    public void register(Utilisateur utilisateur) {
          utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
