package fr.nicolas.trikount.trikount_backend.DTO;

import java.util.List;

import fr.nicolas.trikount.trikount_backend.model.User;

public class UserDTO {

  private Long id;
  private String username;
  private List<SortieDTO> createdSorties;
  private List<SortieDTO> joinedSorties;

  public UserDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.createdSorties = user.getCreatedSorties().stream().map(SortieDTO::new).toList();
    this.joinedSorties = user.getJoinedSorties().stream().map(SortieDTO::new).toList();
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public List<SortieDTO> getCreatedSorties() {
    return createdSorties;
  }

  public List<SortieDTO> getJoinedSorties() {
    return joinedSorties;
  }
}
