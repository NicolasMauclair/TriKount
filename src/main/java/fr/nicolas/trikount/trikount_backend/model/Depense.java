package fr.nicolas.trikount.trikount_backend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "depense")
public class Depense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Long price;

  @ManyToOne
  @JoinColumn(name = "sortie_id")
  private Sortie sortie;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User payedBy;

  @ManyToMany
  @JoinTable(name = "user_depense", joinColumns = @JoinColumn(name = "depense_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private List<User> users;

  public Depense() {
  }

  public Depense(String name, Long price) {
    this.name = name;
    this.price = price;
  }

  // Getters et setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Sortie getSortie() {
    return sortie;
  }

  // Getters et setters des relations

  public void setSortie(Sortie sortie) {
    this.sortie = sortie;
  }

  public User getPayedBy() {
    return payedBy;
  }

  public void setPayedBy(User payedBy) {
    this.payedBy = payedBy;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}
