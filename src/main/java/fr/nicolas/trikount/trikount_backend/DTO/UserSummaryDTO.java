package fr.nicolas.trikount.trikount_backend.DTO;

import fr.nicolas.trikount.trikount_backend.model.User;

public class UserSummaryDTO {
  private Long id;
  private String username;

  public UserSummaryDTO(User user) {
      this.id = user.getId();
      this.username = user.getUsername();
  }

  public Long getId() {
      return id;
  }

  public String getUsername() {
      return username;
  }
}

