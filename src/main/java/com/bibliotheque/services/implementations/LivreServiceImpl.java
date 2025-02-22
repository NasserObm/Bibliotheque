package com.bibliotheque.services.implementations;

import com.bibliotheque.mappers.LivreMapper;
import com.bibliotheque.models.dtos.requests.LivreRequest;
import com.bibliotheque.models.dtos.responses.LivreResponse;
import com.bibliotheque.models.entities.Livre;
import com.bibliotheque.repositories.LivreRepository;
import com.bibliotheque.services.interfaces.LivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivreServiceImpl implements LivreService {
    private final LivreRepository livreRepository;
    private final LivreMapper livreMapper;

    @Override
    public List<LivreResponse> getAllLivres() {
        // Utilisation de Stream pour mapper les entités Livre vers LivreResponse
        return livreRepository.findAll().stream()
                .map(livreMapper::toDtos)  // Utilisation du mapper pour convertir en LivreResponse
                .collect(Collectors.toList());      // Collecte les résultats dans une liste
    }

    @Override
    public Optional<LivreResponse> getLivreById(Long id) {
        // Récupération de l'entité Livre par ID et transformation en LivreResponse via le mapper
        return livreRepository.findById(id)
                .map(livreMapper::toDtos);  // Si trouvé, mappe vers LivreResponse
    }

    @Override
    public LivreResponse createLivre(LivreRequest livreRequest) {
        return livreMapper.toDtos(livreRepository.save(livreMapper.toEntity(livreRequest)));

    }

    @Override
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
