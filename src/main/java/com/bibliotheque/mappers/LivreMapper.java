package com.bibliotheque.mappers;

import com.bibliotheque.models.dtos.requests.LivreRequest;
import com.bibliotheque.models.dtos.responses.LivreResponse;
import com.bibliotheque.models.entities.Livre;
import org.springframework.stereotype.Component;

@Component
public class LivreMapper {
    public Livre toEntity(LivreRequest livreRequest){
        return new Livre().builder()
                .titre(livreRequest.getTitre())
                .auteur(livreRequest.getAuteur())
                .isbn(livreRequest.getIsbn())
                .nombreExemplaires(livreRequest.getNombreExemplaire())
                .build();
    }

    public LivreResponse toDtos(Livre livre){
        return new LivreResponse().builder()
                .titre(livre.getTitre())
                .nombreExemplaire(livre.getNombreExemplaires())
                .auteur(livre.getAuteur())
                .isbn(livre.getIsbn())
                .build();
    }
}
