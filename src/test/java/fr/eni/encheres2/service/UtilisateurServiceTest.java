package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.UtilisateurDTO;
import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.repository.UtilisateurRepository;
import fr.eni.encheres2.service.implementationJPA.UtilisateurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreerUtilisateur() {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setNom("Bombeurre");
        utilisateurDTO.setPrenom("Jean");

        when(utilisateurRepository.save(any())).thenReturn(new Utilisateur());

        utilisateurService.creerUtilisateur(utilisateurDTO);

        verify(utilisateurRepository, times(1)).save(any());
    }

    @Test
    void testTrouverUtilisateurParId() {
        long userId = 1L;
        Utilisateur utilisateur = Utilisateur.builder().noUtilisateur(userId).nom("Bombeurre").prenom("Jean").build();

        when(utilisateurRepository.findById(userId)).thenReturn(java.util.Optional.of(utilisateur));

        UtilisateurDTO userDTO = utilisateurService.trouverUtilisateurParId(userId);

        verify(utilisateurRepository, times(1)).findById(userId);
        assertEquals("Bombeurre", userDTO.getNom());
        assertEquals("Jean", userDTO.getPrenom());
    }

    @Test
    void testModifierUtilisateur() {
        long userId = 1L;
        Utilisateur user = Utilisateur.builder().noUtilisateur(userId).nom("Bombeurre").prenom("Jean").build();
        UtilisateurDTO userDTO = UtilisateurDTO.builder().noUtilisateur(userId).nom("Bombeurre").prenom("Jean").build();

        when(utilisateurRepository.existsById(userId)).thenReturn(true);

        utilisateurService.modifierUtilisateur(userDTO);

        verify(utilisateurRepository, times(1)).existsById(userId);
        verify(utilisateurRepository, times(1)).save(user);
    }

    @Test
    void testSupprimerUtilisateur() {
        long userId = 1L;
        when(utilisateurRepository.existsById(userId)).thenReturn(true);

        utilisateurService.supprimerUtilisateur(userId);

        verify(utilisateurRepository, times(1)).existsById(userId);
        verify(utilisateurRepository, times(1)).deleteById(userId);

    }

    @Test
    void testTousLesUtilisateurs() {
        List<Utilisateur> users = new ArrayList<>();
        users.add(Utilisateur.builder().nom("Bombeurre").prenom("Jean").build());
        users.add(Utilisateur.builder().nom("Paltant").prenom("Roger").build());
        when(utilisateurRepository.findAll()).thenReturn(users);

        List<UtilisateurDTO> result = utilisateurService.tousLesUtilisateurs();

        assertEquals(users.size(), result.size());
    }

}
