package fr.eni.encheres2.repository;

import fr.eni.encheres2.entity.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnchereRepository extends JpaRepository<Enchere, Long> {


}
