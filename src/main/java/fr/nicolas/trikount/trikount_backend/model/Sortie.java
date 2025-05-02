package fr.nicolas.trikount.trikount_backend.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sortie")
public class Sortie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "created_by")
  @JsonBackReference
  private User createdBy;

  @ManyToMany(mappedBy = "joinedSorties")
  private List<User> users = new ArrayList<>();

  @OneToMany(mappedBy = "sortie", cascade = CascadeType.ALL)
    private List<Depense> depenses = new ArrayList<>();


  public Sortie() {
  }

  public Sortie(String name) {
    this.name = name;
  }

  // Getters et setters

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // Getters et setters des relations

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<Depense> getDepenses() {
    return depenses;
  }

  public void setDepenses(List<Depense> depenses) {
    this.depenses = depenses;
  }

}
