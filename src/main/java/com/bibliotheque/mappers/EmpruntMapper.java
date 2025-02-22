package com.bibliotheque.mappers;

import com.bibliotheque.models.dtos.requests.EmpruntRequest;
import com.bibliotheque.models.dtos.responses.EmpruntResponse;
import com.bibliotheque.models.entities.Emprunt;
import com.bibliotheque.models.entities.Livre;
import com.bibliotheque.models.entities.Utilisateur;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmpruntMapper {
    public Emprunt toEntity(EmpruntRequest empruntRequest, Utilisateur utilisateur, Livre livre){
        return new Emprunt().builder()
                .dateEmprunt(LocalDate.now())
                .dateRetourPrevu(empruntRequest.getDateRetourPrevu())
                .penalite(0)
                .livre(livre)
                .utilisateur(utilisateur)
                .build();

    }
    public EmpruntResponse toDtos(Emprunt emprunt) {
        EmpruntResponse response = new EmpruntResponse();
        response.setId(emprunt.getId());
        response.setUtilisateurNom(emprunt.getUtilisateur().getNom());
        response.setLivreTitre(emprunt.getLivre().getTitre());
        response.setDateEmprunt(emprunt.getDateEmprunt());
        response.setDateRetourPrevue(emprunt.getDateRetourPrevu());
        response.setDateRetourReel(emprunt.getDateRetourReel());
        response.setPenalite(emprunt.getPenalite());
        return response;
    }
}

