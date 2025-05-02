package fr.nicolas.trikount.trikount_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nicolas.trikount.trikount_backend.model.users;
import fr.nicolas.trikount.trikount_backend.repository.userRepository;

@Service
public class UserService {

  @Autowired // injecte l'objet UserRepository pour accéder aux données de la base de données (dependance)
  private userRepository userRepository;

  public users getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public users saveUser(users user) {
    return userRepository.save(user);
  }

  public Optional<users> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
