package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.CategorieDto;
import fr.eni.encheres2.entity.Categorie;
import fr.eni.encheres2.exception.CategorieNotFoundException;
import fr.eni.encheres2.repository.CategorieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategorieServiceTests {

    @Autowired
    private CategorieService service;

    @MockBean
    private CategorieRepository categorieRepository;

    private CategorieDto categorieDto;

    private List<Categorie> categories;

    @BeforeEach
    void setUp() {
        categories = Arrays.asList(
                new Categorie(1L, "Categorie 1"),
                new Categorie(2L, "Categorie 2"),
                new Categorie(3L, "Categorie 3")
        );
        categorieDto = new CategorieDto();
        categorieDto.setNoCategorie(1L);
        categorieDto.setLibelle("Categorie 1");
    }

    @AfterEach
    void tearDown() {
        categories = null;
    }

    @Test
    void testCreerCategorie() throws CategorieNotFoundException {
        // Données de test
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setLibelle("Test Libelle");

        // Création d'une instance de Categorie simulée
        Categorie categorie = new Categorie();
        categorie.setLibelle("Test Libelle");

        // Simulation du comportement du repository
        when(categorieRepository.save(any())).thenReturn(categorie);

        // Appel de la méthode à tester
        CategorieDto result = service.creerCategorie(categorieDto);

        // Vérification
        assertNotNull(result);
        assertEquals("Test Libelle", result.getLibelle());

        // Vérifie que la méthode save du repository a été appelée avec le bon paramètre
        verify(categorieRepository, times(1)).save(any());
    }

    @Test
    void testConsulterCategories() {
        // Simulation du comportement du repository
        when(categorieRepository.findAll()).thenReturn(categories);

        // Appel de la méthode à tester
        List<CategorieDto> result = service.consulterCategories();

        // Vérification
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Categorie 1", result.get(0).getLibelle());
        assertEquals("Categorie 2", result.get(1).getLibelle());
        assertEquals("Categorie 3", result.get(2).getLibelle());
    }

    @Test
    void testConsulterCategorieParNo() {
        // Données de test
        Long noCategorie = 1L;
        Categorie categorie = categories.get(0);

        // Simulation du comportement du repository
        when(categorieRepository.findById(noCategorie)).thenReturn(Optional.of(categorie));

        // Appel de la méthode à tester
        CategorieDto result = service.consulterCategorieParNo(noCategorie);

        // Vérification
        assertNotNull(result);
        assertEquals("Categorie 1", result.getLibelle());
    }

    @Test
    void testModifierCategorie() {
        // Simulation du comportement du repository
        when(categorieRepository.existsById(categorieDto.getNoCategorie())).thenReturn(true);
        when(categorieRepository.save(any())).thenReturn(new Categorie());

        // Appel de la méthode à tester
        assertDoesNotThrow(() -> service.modifierCategorie(categorieDto));

        // Vérifie que la méthode save du repository a été appelée avec le bon paramètre
        verify(categorieRepository, times(1)).save(any());
    }

    @Test
    void testSupprimerCategorie() {
        // Données de test
        Long noCategorie = 1L;

        // Appel de la méthode à tester
        assertDoesNotThrow(() -> service.supprimerCategorie(noCategorie));

        // Vérifie que la méthode deleteById du repository a été appelée avec le bon paramètre
        verify(categorieRepository, times(1)).deleteById(noCategorie);

    }

}