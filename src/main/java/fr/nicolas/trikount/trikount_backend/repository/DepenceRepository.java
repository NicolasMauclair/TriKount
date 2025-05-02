package fr.nicolas.trikount.trikount_backend.repository;

import fr.nicolas.trikount.trikount_backend.model.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenceRepository extends JpaRepository<Sortie, Long> {
}
