package com.bibliotheque.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "livres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String isbn;
    private int nombreExemplaires;

    @OneToMany(mappedBy = "livre")
    List<Emprunt> emprunts;
}

