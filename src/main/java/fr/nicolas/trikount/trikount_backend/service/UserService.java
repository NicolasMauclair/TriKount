package fr.nicolas.trikount.trikount_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nicolas.trikount.trikount_backend.DTO.SortieDTO;
import fr.nicolas.trikount.trikount_backend.DTO.UserDTO;
import fr.nicolas.trikount.trikount_backend.model.User;
import fr.nicolas.trikount.trikount_backend.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // Crée un utilisateur
  public UserDTO createUser(User user) {
    if (userRepository.findByUsername(user.getUsername()) != null) {
      throw new RuntimeException("Username already exists");
    }
    return new UserDTO(userRepository.save(user));
  }

  // Recherche un utilisateur par son username
  public UserDTO getUserByUsername(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null)
      throw new RuntimeException("User not found");
    return new UserDTO(user);
  }

  // Recherche un utilisateur par son ID
  public UserDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
    return new UserDTO(user);
  }

  public List<SortieDTO> getSortiesJoinedByUser(Long idUser) {
    User user = userRepository.findById(idUser)
        .orElseThrow(() -> new RuntimeException("User not found"));
    return user.getJoinedSorties().stream()
        .map(SortieDTO::new)
        .collect(Collectors.toList());
  }

  public List<SortieDTO> getSortiesCreatedByUser(Long idUser) {
    User user = userRepository.findById(idUser)
        .orElseThrow(() -> new RuntimeException("User not found"));
    return user.getCreatedSorties().stream()
        .map(SortieDTO::new)
        .collect(Collectors.toList());
  }

  // Récupère tous les utilisateurs
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream()
        .map(UserDTO::new)
        .collect(Collectors.toList());
  }

  // Supprime un utilisateur
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}