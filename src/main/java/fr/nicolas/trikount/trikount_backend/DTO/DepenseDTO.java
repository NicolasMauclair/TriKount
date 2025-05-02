package fr.nicolas.trikount.trikount_backend.DTO;

import java.util.List;

import fr.nicolas.trikount.trikount_backend.model.Depense;

public class DepenseDTO {
  private Long id;
  private String name;
  private Long price;
  private long PayedById;
  private List<Long> usersId;

  public DepenseDTO(Depense depense) {
    this.id = depense.getId();
    this.name = depense.getName();
    this.price = depense.getPrice();
    this.PayedById = depense.getPayedBy().getId();
    this.usersId = depense.getUsers().stream().map(user -> user.getId()).toList();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public long getPayedById() {
    return PayedById;
  }

  public List<Long> getUsersId() {
    return usersId;
  }
}