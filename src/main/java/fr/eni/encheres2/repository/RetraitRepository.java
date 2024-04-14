package fr.eni.encheres2.repository;

import fr.eni.encheres2.entity.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetraitRepository extends JpaRepository<Retrait, Long> {
}