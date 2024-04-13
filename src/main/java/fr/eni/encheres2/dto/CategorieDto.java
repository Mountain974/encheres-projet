package fr.eni.encheres2.dto;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategorieDto {
    @Id
    private Long noCategorie;

    @NotNull(message = "le libellé de la catégorie est obligatoire")
    @Size(max=30)
    private String libelle;

    public CategorieDto(Long noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }
}
