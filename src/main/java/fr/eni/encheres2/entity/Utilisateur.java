package fr.eni.encheres2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // génère getter/setter/
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    private Long id;


}
