package fr.eni.encheres2.controller;

import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.security.JwtUtils;
import fr.eni.encheres2.security.MyUserDetailsService;
import fr.eni.encheres2.security.UtilisateurSpringSecurity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

public class ConnectedUserController {

    private final JwtUtils jwtUtils;
    private final MyUserDetailsService userDetailsService;

    public ConnectedUserController(JwtUtils jwtUtils, MyUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public Utilisateur getConnectedUser(HttpServletRequest request) throws Exception {
        // recupère le nom d'utilisateur correspondant au token JWT de la requête
        String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.parseJwt(request));
        // recupère l'utilisateur Spring Security correspondant à ce nom d'utilisateur
        UtilisateurSpringSecurity user = (UtilisateurSpringSecurity) userDetailsService.loadUserByUsername(username);
        // renvoie le membre correspondant
        return user.getUser();
    }
}
