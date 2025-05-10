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
import fr.nicolas.trikount.trikount_backend.DTO.SortieRequest;
import fr.nicolas.trikount.trikount_backend.service.SortieService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/api/sortie")
public class SortieController {

  @Autowired
  private SortieService sortieService;  

  // Crée une sortie
  @PostMapping("/createSortie")
  public ResponseEntity<SortieDTO> createSortie(@RequestBody SortieRequest request) {
    SortieDTO sortie = sortieService.createSortie(request.getUserId(), request.getGroupName(), request.getUserIds());
    return new ResponseEntity<>(sortie, HttpStatus.CREATED);
  }

  // Récupérer une sortie à partir de son id
  @GetMapping("/getSortie/{id}")
  public ResponseEntity<SortieDTO> getSortie(@PathVariable Long id) {
    SortieDTO sortie = sortieService.getSortie(id);
    return new ResponseEntity<>(sortie, HttpStatus.OK);
  }

  // Récupérer toutes les sorties
  @GetMapping("/getSorties")
  public ResponseEntity<List<SortieDTO>> getAllSortie() {
    List<SortieDTO> sorties = sortieService.getAllSortie();
    return new ResponseEntity<>(sorties, HttpStatus.OK);
  }

  // Supprimer une sortie
  @DeleteMapping("/deleteSortie/{idSortie}/user/{idUser}")
  public ResponseEntity<String> deleteSortie(@PathVariable Long idSortie, @PathVariable Long idUser) {
      boolean deleted = sortieService.deleteSortieIfCreator(idSortie, idUser);
      if (deleted) {
          return new ResponseEntity<>("Sortie deleted", HttpStatus.OK);
      } else {
          return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
      }
  }

}
  
