package com.greenfoxacademy.foxclubwithsql.models;

import com.greenfoxacademy.foxclubwithsql.models.enums.Gender;


import javax.persistence.*;

@Entity
@Table(name = "manatee")

public class Manatee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private Gender gender;

  @ManyToOne
  private Nutrition currentFood;

  @ManyToOne
  private Nutrition currentDrink;

  @ManyToOne
  private User owner;

  public Manatee() {
  }

  public Manatee(String name, Gender gender) {
    this.name = name;
    this.gender = gender;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public Nutrition getCurrentFood() {
    return currentFood;
  }

  public Nutrition getCurrentDrink() {
    return currentDrink;
  }

  public User getOwner() {
    return owner;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setCurrentFood(Nutrition currentFood) {
    this.currentFood = currentFood;
  }

  public void setCurrentDrink(Nutrition currentDrink) {
    this.currentDrink = currentDrink;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}
