package fr.eni.encheres2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EnchereDTO {

    @Id
    private Long id;

    @NotNull(message = "la date de l'enchère obligatoire")
    private LocalDate dateEnchere;

}