package com.bibliotheque.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntRequest {
    private Long utilisateurId;
    private Long livreId;
    private LocalDate dateRetourPrevu;
}
