package fr.eni.encheres2.controller;

import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @PostMapping
    public String login(@RequestBody Utilisateur user) throws Exception {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(user.getPseudo(), user.getMotDePasse());
        Authentication authentication = authenticationConfiguration.getAuthenticationManager().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // génère et retourne un token
        return jwtUtils.generateJwtToken(authentication);
    }
}