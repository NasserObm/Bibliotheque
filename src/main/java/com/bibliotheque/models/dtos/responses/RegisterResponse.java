package com.bibliotheque.models.dtos.responses;

import com.bibliotheque.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterResponse {
    private String nom;
    private String email;
    private Role role;
}
