package com.bibliotheque.controllers;

import com.bibliotheque.models.dtos.requests.AuthRequest;
import com.bibliotheque.models.dtos.requests.RegisterRequest;
import com.bibliotheque.models.dtos.responses.AuthResponse;
import com.bibliotheque.models.dtos.responses.RegisterResponse;
import com.bibliotheque.models.entities.Utilisateur;
import com.bibliotheque.models.enums.Role;
import com.bibliotheque.securites.JwtUtil;
import com.bibliotheque.services.implementations.UtilisateurServiceImpl;
import com.bibliotheque.services.interfaces.UtilisateurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UtilisateurServiceImpl utilisateurService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
       try {
        Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getMotDePasse()));
        if (authenticate.isAuthenticated()){
            Map<String, Object> authData=new HashMap<>();
            authData.put("token", jwtUtil.generateToken(authRequest.getEmail()));
            authData.put("type","Bearer");
            return ResponseEntity.ok(authData);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid email or password");
       }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid email or password");
       }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (registerRequest.getMotDePasse() == null || registerRequest.getMotDePasse().isBlank()) {
            return ResponseEntity.badRequest().body("Le mot de passe ne peut pas être vide");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(registerRequest.getNom());
        utilisateur.setEmail(registerRequest.getEmail());
        utilisateur.setMotDePasse(passwordEncoder.encode(registerRequest.getMotDePasse()));
        utilisateur.setRole(registerRequest.getRole());
        utilisateurService.register(utilisateur);

        String token = jwtUtil.generateToken(utilisateur.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
