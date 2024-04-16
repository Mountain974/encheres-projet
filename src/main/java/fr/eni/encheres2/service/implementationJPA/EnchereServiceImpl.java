package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.entity.Enchere;
import fr.eni.encheres2.exception.EnchereNotFoundException;
import fr.eni.encheres2.mapping.EnchereMapper;
import fr.eni.encheres2.repository.EnchereRepository;
import fr.eni.encheres2.service.EnchereService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnchereServiceImpl implements EnchereService {

    private EnchereMapper modelMapper;

    private EnchereRepository enchereRepository;

    @Autowired
    public EnchereServiceImpl(EnchereMapper modelMapper, EnchereRepository enchereRepository){
        this.modelMapper = modelMapper;
        this.enchereRepository = enchereRepository;
    }

    @Override
    public List<EnchereDTO1> consulterEncheres() {
        return enchereRepository.findAll().stream()
                .map(enchere -> modelMapper.mapToDto(enchere)).collect(Collectors.toList());
    }

    @Override
    public EnchereDTO1 consulterEnchereParId(Long id) {
        Enchere enchere = enchereRepository.findById(id).orElseThrow(() -> { throw new EnchereNotFoundException("L'enchère demandée n'existe pas");});
        return modelMapper.mapToDto(enchere);
    }

    @Override
    public EnchereDTO1 creerEnchere(@Valid @NotNull EnchereDTO1 enchere) {
        return modelMapper.mapToDto(enchereRepository.save(modelMapper.mapToEntity(enchere)));
    }

    @Override
    public List<EnchereDTO1> afficherEncheresParUtilisateur(Long noUtilisateur) {
        return null;
    }
}
