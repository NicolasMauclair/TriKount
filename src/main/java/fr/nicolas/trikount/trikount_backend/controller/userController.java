package fr.nicolas.trikount.trikount_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolas.trikount.trikount_backend.DTO.SortieDTO;
import fr.nicolas.trikount.trikount_backend.DTO.UserDTO;
import fr.nicolas.trikount.trikount_backend.model.User;
import fr.nicolas.trikount.trikount_backend.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/bonjour")
  public String sayHello() {
    return "Bonjour";
  }

  // Crée un utilisateur
  @PostMapping("/createUser")
  public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
    UserDTO createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  // Recherche un utilisateur par son username
  @GetMapping("/searchUserByUsername/{username}")
  public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
    try {
      UserDTO user = userService.getUserByUsername(username);
      return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  // Recherche un utilisateur par son ID
  @GetMapping("/searchUserById/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
    try {
      UserDTO user = userService.getUserById(id);
      return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  // Récupère tous les utilisateurs
  @GetMapping("/getAllUsers")
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    List<UserDTO> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  // Récupère les sorties auxquelles un utilisateur participe
  @GetMapping("/getSortiesJoinedByUser/{idUser}")
  public ResponseEntity<List<SortieDTO>> getSortiesJoinedByUser(@PathVariable Long idUser) {
    List<SortieDTO> sorties = userService.getSortiesJoinedByUser(idUser);
    return new ResponseEntity<>(sorties, HttpStatus.OK);
  }

  // Récupère les sorties auxquelles un utilisateur a créé
  @GetMapping("/getSortiesCreatedByUser/{idUser}")
  public ResponseEntity<List<SortieDTO>> getSortiesCreatedByUser(@PathVariable Long idUser) {
    List<SortieDTO> sorties = userService.getSortiesCreatedByUser(idUser);
    return new ResponseEntity<>(sorties, HttpStatus.OK);
  }

  // Supprime un utilisateur
  @DeleteMapping("/deleteUser/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("User deleted", HttpStatus.OK);
  }
}
