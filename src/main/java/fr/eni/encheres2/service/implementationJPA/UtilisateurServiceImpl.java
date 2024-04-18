package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.UtilisateurDTO;
import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.repository.UtilisateurRepository;
import fr.eni.encheres2.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final PasswordEncoder encoder;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder encoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.encoder = encoder;
    }

    @Override
    public void creerUtilisateur(UtilisateurDTO utilisateurDTO) {
        if (utilisateurRepository.existsByPseudo(utilisateurDTO.getPseudo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un utilisateur avec ce pseudo existe déjà !");
        }

        if (utilisateurRepository.existsByEmail(utilisateurDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un utilisateur avec cet email existe déjà !");
        }
        Utilisateur utilisateur = modelMapper.map(utilisateurDTO, Utilisateur.class);
        utilisateur.setMotDePasse(encoder.encode(utilisateur.getMotDePasse()));
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public UtilisateurDTO trouverUtilisateurParId(long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas."));
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }

    @Override
    public UtilisateurDTO trouverUtilisateurParEmail(String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }

    @Override
    public UtilisateurDTO trouverUtilisateurParPseudo(String pseudo) {
        Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }

    @Override
    public void modifierUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = modelMapper.map(utilisateurDTO, Utilisateur.class);
        if (utilisateurRepository.existsById(utilisateur.getNoUtilisateur())) {
            utilisateurRepository.save(utilisateur);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas.");
        }
    }

    @Override
    public void supprimerUtilisateur(long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas.");
        }
    }

    @Override
    public List<UtilisateurDTO> tousLesUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(utilisateur -> modelMapper.map(utilisateur, UtilisateurDTO.class))
                .collect(Collectors.toList());
    }
}
