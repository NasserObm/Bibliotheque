package com.bibliotheque.models.dtos.requests;

import com.bibliotheque.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String email;
    private String motDePasse;
    private Role role;
}
