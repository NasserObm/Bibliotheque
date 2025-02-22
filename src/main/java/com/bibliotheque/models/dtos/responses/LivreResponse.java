package com.bibliotheque.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivreResponse {
    private String titre;
    private String auteur;
    private String  isbn;
    private int nombreExemplaire;
}
