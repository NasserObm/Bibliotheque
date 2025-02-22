package com.bibliotheque.models.entities;

import com.bibliotheque.models.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utilisateurs")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Emprunt> emprunts;
}
