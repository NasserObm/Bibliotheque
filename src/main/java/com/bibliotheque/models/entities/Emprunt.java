package com.bibliotheque.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "emprunts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emprunt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id")
    private Livre livre;

    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private LocalDate dateRetourReel;

    private double penalite;

}

