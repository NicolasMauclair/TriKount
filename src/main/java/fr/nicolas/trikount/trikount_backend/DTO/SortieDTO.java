package fr.nicolas.trikount.trikount_backend.DTO;

import java.util.List;

import fr.nicolas.trikount.trikount_backend.model.Sortie;

public class SortieDTO {
  private Long id;
  private String name;
  private Long CreatedById;
  private List<UserSummaryDTO> users;
  private List<DepenseDTO> depenses;
  
  public SortieDTO(Sortie sortie) {
    this.id = sortie.getId();
    this.name = sortie.getName();
    this.CreatedById = sortie.getCreatedBy().getId();
    this.users = sortie.getUsers().stream().map(UserSummaryDTO::new).toList();
    this.depenses = sortie.getDepenses().stream().map(DepenseDTO::new).toList();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getCreatedById() {
    return CreatedById;
  }

  public List<UserSummaryDTO> getUsersId() {
    return users;
  }

  public List<DepenseDTO> getDepensesId() {
    return depenses;
  }
  
}
