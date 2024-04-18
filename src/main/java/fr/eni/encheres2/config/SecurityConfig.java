package fr.eni.encheres2.config;

import fr.eni.encheres2.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // ignore la vérification csrf sur les requêtes d'API (pas de risque car pas de Cookies)
        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/api/**"));

        // autorise la requête http entrante en fonction de ces critères :
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/**").permitAll()
                )
                // utilise une authentification simple username / mot de passe
                .httpBasic(Customizer.withDefaults())
                // utilise le formulaire par défaut proposé par Spring Security
                .formLogin(Customizer.withDefaults())
                // quand on se déconnecte => on redirige vers l'accueil
                .logout((logout) -> logout.logoutSuccessUrl("/"));

        /*****************************************************************
         * AVANT DE FAIRE LA VERIFICATION DE SECURITE, ON AJOUTE UN FILTRE
         * qui va vérifier la présence ou non d'un Json Web Token
         *
         * il va remplir le contexte Spring Security
         * à partir du token JWT
         ******************************************************************/
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
