package fr.nicolas.trikount.trikount_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nicolas.trikount.trikount_backend.model.users;

@Repository // Permet injection dans d'autres services
public interface userRepository extends JpaRepository<users, Long> {

  users findByUsername(String username);
}
