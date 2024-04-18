package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.CategorieDTO;
import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.mapping.RetraitMapper;
import fr.eni.encheres2.entity.Retrait;
import fr.eni.encheres2.repository.RetraitRepository;
import fr.eni.encheres2.service.RetraitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetraitServiceImpl implements RetraitService {
    private final RetraitMapper modelMapper;
    private final RetraitRepository retraitRepository;

    @Autowired
    public RetraitServiceImpl(RetraitMapper modelMapper, RetraitRepository retraitRepository){
        this.modelMapper = modelMapper;
        this.retraitRepository = retraitRepository;
    }

    @Override
    public List<RetraitDTO> consulterRetraits() {
        return retraitRepository.findAll().stream()
                .map(retrait -> modelMapper.mapToDto(retrait)).collect(Collectors.toList() );
    }

    @Override
    public RetraitDTO consulterRetraitParId(Long noArticle) {
        Retrait retrait = retraitRepository.findById(noArticle).
                orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'adresse n'existe pas");});
        return modelMapper.mapToDto(retrait);
    }

    @Override
    public RetraitDTO creerRetrait(@Valid @NotNull RetraitDTO retraitDTO) {
        return modelMapper.mapToDto(retraitRepository.save(modelMapper.mapToEntity(retraitDTO)));
    }

    @Override
    public void modifierRetrait(RetraitDTO retraitDTO) {

        Retrait retrait = modelMapper.mapToEntity(retraitDTO);
        if (retraitRepository.existsById(retrait.getNoArticle())){
            retraitRepository.save(retrait);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la retrait n'existe pas");
        }
    }


    @Override
    public void supprimerRetrait(@NotNull Long noArticle) {
        if (retraitRepository.findById(noArticle).isPresent()){
            retraitRepository.deleteById(noArticle);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'adresse n'existe pas");
        }
    }

}
