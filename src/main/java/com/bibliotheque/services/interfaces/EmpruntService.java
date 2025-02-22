package com.bibliotheque.services.interfaces;

import com.bibliotheque.models.dtos.requests.EmpruntRequest;
import com.bibliotheque.models.dtos.responses.EmpruntResponse;

public interface EmpruntService {
    EmpruntResponse emprunterLivre(EmpruntRequest empruntRequest);
    EmpruntResponse retournerLivre(Long id);
}
