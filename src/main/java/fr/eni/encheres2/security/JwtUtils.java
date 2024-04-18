package fr.eni.encheres2.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Component
public class JwtUtils {
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    /**
     * génère un JWT depuis l'utilisateur courant en incluant son nom d'utilisateur dans le payload
     */
    public String generateJwtToken(Authentication authentication) {
        UtilisateurSpringSecurity userPrincipal = (UtilisateurSpringSecurity) authentication.getPrincipal();
        // JWT.create().withClaim(ATTR) crée un token JWT en mettant dans le payload l'attribut ATTR
        return JWT.create().withClaim("username", userPrincipal.getUsername()).sign(Algorithm.HMAC256(jwtSecret));
    }

    /**
     * recupère depuis le token un attribut (username) mis dans le payload
     */
    public String getUserNameFromJwtToken(String token) {
        // JWT.require().verify().getClaim(ATTR) : recupère l'attribut  ATTR contenu dans le token JWT decrypté
        return JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token).getClaim("username").toString().replaceAll("\"", "");
    }

    /**
     * recupère l'entête Authorization de notre requête HTTP
     * et le JWT va correspondre à la chaîne de caractère après Bearer XXXXXXX
     */
    public static String parseJwt(HttpServletRequest request) {
        // 1 - on recupère l'entête "Authorization"
        String headerAuth = request.getHeader("Authorization");

        // 2 - on recupère à la chaîne de caractère après Bearer XXXXXXX
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }

    /**
     * On va valider que le token correspond à l'algorithme choisi (HMAC256) et au secret définit dans l'attribut jwtSecret
     * Pour cela, on va se baser sur la bibliothèque JWT ('com.auth0:java-jwt:4.0.0')
     */
    public boolean validateJwtToken(String authToken) {
        try {
            // JWT.require().verify() : vérifie qu'un token est valide et conforme à l'algorithme et secret défini
            JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(authToken);
            return true;
        } catch (Exception e) {
            System.out.println("error : " + Arrays.toString(e.getStackTrace()));
        }
        return false;
    }
}