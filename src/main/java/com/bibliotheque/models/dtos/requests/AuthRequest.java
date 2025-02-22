package com.bibliotheque.models.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String email;
    private String motDePasse;
}

