package fr.eni.encheres2.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // génère getter/setter/
@NoArgsConstructor
@AllArgsConstructor
public class RetraitDTO {
    @Id
    private Long noArticle;
    @NotNull(message = "la rue est obligatoire")
    @Size(max=50)
    private String rue;
    @NotNull(message = "le code postal est obligatoire")
    @Size(min=5, max=5)
    private String code_postal;
    @NotNull(message = "la ville est obligatoire")
    @Size(max=45)
    private String ville;



}
