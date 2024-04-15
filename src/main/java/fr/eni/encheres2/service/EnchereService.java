package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.EnchereDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnchereService {

    List<EnchereDto> consulterEncheres();

    EnchereDto consulterEnchereParId(Long id);

    EnchereDto creerEnchere(EnchereDto enchere);

}
