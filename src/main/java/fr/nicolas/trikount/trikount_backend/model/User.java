package fr.nicolas.trikount.trikount_backend.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;

  @OneToMany(mappedBy = "createdBy")
  @JsonManagedReference
  private List<Sortie> createdSorties = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "users_sortie", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "sortie_id"))
  private List<Sortie> joinedSorties = new ArrayList<>();

  @OneToMany(mappedBy = "payedBy")
  private List<Depense> depensesCreated = new ArrayList<>();

  @ManyToMany(mappedBy = "users")
  private List<Depense> depensesImplicated;

  // Constructeurs

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters et Setters

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // Getters et setters des relations

  public List<Sortie> getCreatedSorties() {
    return this.createdSorties;
  }

  public List<Sortie> getJoinedSorties() {
    return this.joinedSorties;
  }

  public List<Depense> getDepensesCreated() {
    return this.depensesCreated;
  }

  public List<Depense> getDepensesImplicated() {
    return this.depensesImplicated;
  }
}
