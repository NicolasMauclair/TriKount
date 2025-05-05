package fr.nicolas.trikount.trikount_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nicolas.trikount.trikount_backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  User findByUsernameAndPassword(String username, String password);
}
