package com.bibliotheque.mappers;

import com.bibliotheque.models.dtos.requests.RegisterRequest;
import com.bibliotheque.models.dtos.responses.RegisterResponse;
import com.bibliotheque.models.entities.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterMapper {
    private final PasswordEncoder passwordEncoder;
    public Utilisateur toEntity(RegisterRequest registerRequest){
        return  Utilisateur.builder()
                .nom(registerRequest.getNom())
                .email(registerRequest.getEmail())
                .motDePasse(passwordEncoder.encode(registerRequest.getMotDePasse()))
                .role(registerRequest.getRole())
                .build();
    }

    public RegisterResponse toDtos(Utilisateur utilisateur){
        return RegisterResponse.builder()
                .email(utilisateur.getEmail())
                .nom(utilisateur.getNom())
                .role(utilisateur.getRole())
                .build();
    }
}
