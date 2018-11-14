package com.greenfoxacademy.foxclubwithsql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String password;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Manatee> manatees;

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
}
