package com.bibliotheque.controllers;

import com.bibliotheque.models.dtos.requests.LivreRequest;
import com.bibliotheque.models.dtos.responses.LivreResponse;
import com.bibliotheque.services.implementations.LivreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/livres")
@RequiredArgsConstructor
public class LivreController {

    private final LivreServiceImpl livreService;  // Injection via @RequiredArgsConstructor

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LivreResponse> createLivre(@RequestBody LivreRequest livreRequest) {
        LivreResponse livreResponse = livreService.createLivre(livreRequest);
        return ResponseEntity.ok(livreResponse);  // Renvoi d'une réponse avec le livre créé
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        livreService.deleteLivre(id);  // Suppression du livre
        return ResponseEntity.noContent().build();  // Réponse HTTP 204 (No Content)
    }

    @GetMapping
    public List<LivreResponse> getAll(){
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Optional<LivreResponse> getById(Long id){
        return livreService.getLivreById(id);
    }
}
