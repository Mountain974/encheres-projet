package fr.eni.encheres2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data // génère getter/setter/
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RETRAITS")
public class Retrait {
    @Id
    @Column(name = "no_article")
    private Long noArticle;
    @NotNull(message = "la rue est obligatoire")
    @Column(length = 50, nullable = false)
    @Size(max=50)
    private String rue;
    @NotNull(message = "le code postal est obligatoire")
    @Column(name = "code_postal", length = 5, nullable = false)
    @Size(min=5, max=5)
    private String codePostal;
    @NotNull(message = "la ville est obligatoire")
    @Column(length = 45, nullable = false)
    @Size(max=45)
    private String ville;



}
