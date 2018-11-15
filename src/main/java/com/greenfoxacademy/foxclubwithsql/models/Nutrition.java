package com.greenfoxacademy.foxclubwithsql.models;

import com.greenfoxacademy.foxclubwithsql.models.enums.NutritionType;

import javax.persistence.*;

@Entity
@Table(name = "nutrition")

public class Nutrition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private NutritionType type;
  private String name;

  public Nutrition() {
  }

  public Nutrition(NutritionType type, String name) {
    this.type = type;
    this.name = name;
  }

  public NutritionType getType() {
    return type;
  }

  public void setType(NutritionType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
}
