package com.bibliotheque.services.interfaces;

import com.bibliotheque.models.dtos.requests.LivreRequest;
import com.bibliotheque.models.dtos.responses.LivreResponse;
import com.bibliotheque.models.entities.Livre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivreService {
    List<LivreResponse> getAllLivres();
    Optional<LivreResponse> getLivreById(Long id);
    LivreResponse createLivre(LivreRequest livreRequest);
    void deleteLivre(Long id);
}

