package com.bibliotheque.controllers;

import com.bibliotheque.models.dtos.requests.EmpruntRequest;
import com.bibliotheque.models.dtos.responses.EmpruntResponse;
import com.bibliotheque.services.implementations.EmpruntServiceImpl;
import com.bibliotheque.services.interfaces.EmpruntService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/emprunts")
@RequiredArgsConstructor
@Tag(name = "Emprunts", description = "Gestion des emprunts")
public class EmpruntController {

    private final EmpruntServiceImpl empruntService;
    @Operation(summary = "Emprunter un livre")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<EmpruntResponse> emprunterLivre(@RequestBody EmpruntRequest request) {
        EmpruntResponse response = empruntService.emprunterLivre(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Retourner un livre")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{empruntId}")
    public ResponseEntity<EmpruntResponse> retournerLivre(@PathVariable Long empruntId) {
        EmpruntResponse response = empruntService.retournerLivre(empruntId);
        return ResponseEntity.ok(response);
    }

}
