package com.bibliotheque.services.implementations;

import com.bibliotheque.models.entities.Utilisateur;
import com.bibliotheque.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur=utilisateurRepository.findByEmailIgnoreCase(email).orElseThrow(()->new UsernameNotFoundException("Aucun Utilisateur avec cet email"));

        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+utilisateur.getRole())));
    }
}
