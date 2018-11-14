package com.greenfoxacademy.foxclubwithsql.models;

import com.greenfoxacademy.foxclubwithsql.models.enums.NutritionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nutrition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private NutritionType type;
  private String name;

  public Nutrition(NutritionType type, String name) {
    this.type = type;
    this.name = name;
  }
}
