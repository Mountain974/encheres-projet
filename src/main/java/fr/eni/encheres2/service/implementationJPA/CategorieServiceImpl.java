package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.CategorieDTO;
import fr.eni.encheres2.exception.CategorieNotFoundException;
import fr.eni.encheres2.mapping.CategorieMapper;
import fr.eni.encheres2.entity.Categorie;
import fr.eni.encheres2.repository.CategorieRepository;
import fr.eni.encheres2.service.CategorieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieMapper modelMapper;

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieMapper modelMapper, CategorieRepository categorieRepository){
        this.modelMapper = modelMapper;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<CategorieDTO> consulterCategories() {
        return categorieRepository.findAll().stream()
                .map(categorie -> modelMapper.mapToDto(categorie)).collect(Collectors.toList());
    }

    @Override
    public CategorieDTO consulterCategorieParNo(Long noCategorie) {
        Categorie categorie = categorieRepository.findById(noCategorie).orElseThrow(() -> { throw new CategorieNotFoundException("La catégorie demandée n'existe pas");});
        return modelMapper.mapToDto(categorie);
    }

    @Override
    public CategorieDTO creerCategorie(@Valid @NotNull CategorieDTO categorie) {
        return modelMapper.mapToDto(categorieRepository.save(modelMapper.mapToEntity(categorie)));
    }

    @Override
    public void supprimerCategorie(@NotNull Long noCategorie) {
        categorieRepository.deleteById(noCategorie);
    }

    @Override
    public void modifierCategorie(CategorieDTO categorieDto) {
        Categorie categorie = modelMapper.mapToEntity(categorieDto);
        if (categorieRepository.existsById(categorie.getNoCategorie())){
            categorieRepository.save(categorie);
        } else {
            throw new CategorieNotFoundException("la catégorie n'existe pas");
        }
    }
}
