package com.greenfoxacademy.foxclubwithsql.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "felhasznalo")

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String password;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Manatee> manatees;

  public User() {
  }

  public void addManatee(Manatee manatee) {
    manatees.add(manatee);
    manatee.setOwner(this);
  }

  public void removeManatee(long manateeId) {
    manatees.remove(getManateeById(manateeId));
  }

  public Manatee getUsersManateeById(long manateeId) {
    return getManateeById(manateeId);
  }

  private Manatee getManateeById(long manateeId) {
    return manatees.stream()
        .filter(manatee -> manatee.getId() == manateeId)
        .findFirst()
        .orElse(null);
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

  public List<Manatee> getManatees() {
    return manatees;
  }

  public void setManatees(List<Manatee> manatees) {
    this.manatees = manatees;
  }

  public long getId() {
    return id;
  }
}
