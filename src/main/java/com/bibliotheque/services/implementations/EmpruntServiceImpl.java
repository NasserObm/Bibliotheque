package com.bibliotheque.services.implementations;

import com.bibliotheque.mappers.EmpruntMapper;
import com.bibliotheque.models.dtos.requests.EmpruntRequest;
import com.bibliotheque.models.dtos.responses.EmpruntResponse;
import com.bibliotheque.models.entities.Emprunt;
import com.bibliotheque.models.entities.Livre;
import com.bibliotheque.models.entities.Utilisateur;
import com.bibliotheque.repositories.EmpruntRepository;
import com.bibliotheque.repositories.LivreRepository;
import com.bibliotheque.repositories.UtilisateurRepository;
import com.bibliotheque.services.interfaces.EmpruntService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmpruntServiceImpl implements EmpruntService {
    double PENALITE_PAR_JOUR=1000;
    private final EmpruntMapper empruntMapper;

    private final EmpruntRepository empruntRepository;


    private final LivreRepository livreRepository;

    private final UtilisateurRepository utilisateurRepository;

    public EmpruntResponse emprunterLivre(EmpruntRequest request) {
        Utilisateur utilisateur = utilisateurRepository.findById(request.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        Livre livre = livreRepository.findById(request.getLivreId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

        if (livre.getNombreExemplaires() <= 0) {
            throw new RuntimeException("Livre non disponible");
        }

        // Créer l'emprunt à partir du request
        Emprunt emprunt = empruntMapper.toEntity(request, utilisateur, livre);
        empruntRepository.save(emprunt);

        livre.setNombreExemplaires(livre.getNombreExemplaires() - 1);
        livreRepository.save(livre);

        // Convertir l'entité emprunt en réponse
        return empruntMapper.toDtos(emprunt);
    }


    @Override
    public EmpruntResponse retournerLivre(Long empruntId) {
        Emprunt emprunt = empruntRepository.findById(empruntId)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé"));

        LocalDate dateRetourEffective = LocalDate.now();
        emprunt.setDateRetourReel(dateRetourEffective);

        // Calcul de la pénalité en cas de retard
        long joursDeRetard = ChronoUnit.DAYS.between(emprunt.getDateRetourPrevu(), dateRetourEffective);
        if (joursDeRetard > 0) {
            emprunt.setPenalite(joursDeRetard * PENALITE_PAR_JOUR);
        }

        Livre livre = emprunt.getLivre();
        livre.setNombreExemplaires(livre.getNombreExemplaires() + 1);
        livreRepository.save(livre);

        empruntRepository.save(emprunt);

        return empruntMapper.toDtos(emprunt);
    }




}
