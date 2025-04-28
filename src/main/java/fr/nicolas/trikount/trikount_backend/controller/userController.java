package fr.nicolas.trikount.trikount_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolas.trikount.trikount_backend.model.users;
import fr.nicolas.trikount.trikount_backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class userController {

  @Autowired
  private UserService userService;

  @GetMapping("/bonjour")
    public String sayHello() {
        return "Bonjour";
    }

  @GetMapping("/{username}")
  public ResponseEntity<String> getUser(@PathVariable String username) {
    users user = userService.getUserByUsername(username);
    if (user != null) {
      return new ResponseEntity<>("User found", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
  }
}