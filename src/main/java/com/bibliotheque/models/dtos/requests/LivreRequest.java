package com.bibliotheque.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivreRequest {
    private String titre;
    private String auteur;
    private String isbn;
    private int nombreExemplaire;
}
