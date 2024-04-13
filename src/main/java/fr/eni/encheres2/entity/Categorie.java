package fr.eni.encheres2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "CATEGORIES")
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="no_categorie")
    private Long noCategorie;

    @NotNull(message = "le libellé de la catégorie est obligatoire")
    @Size(max=30)
    @Column(length = 30, nullable = false)
    private String libelle;

    public Categorie(long noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }

}
