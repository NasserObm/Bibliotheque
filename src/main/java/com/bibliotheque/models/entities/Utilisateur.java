package com.bibliotheque.models.entities;

import com.bibliotheque.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "utilisateurs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String motDePasse;
    @Column(nullable = false)
    private Role role;
}
