package fr.eni.encheres2.security;

import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService, CommandLineRunner {

    @Autowired
    private UtilisateurRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Utilisateur user = userRepo.findByPseudo(pseudo);

        if (user == null) {
            throw new UsernameNotFoundException(pseudo);
        }

        return new UtilisateurSpringSecurity(user);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Utilisateur> users = userRepo.findAll();
    }
}