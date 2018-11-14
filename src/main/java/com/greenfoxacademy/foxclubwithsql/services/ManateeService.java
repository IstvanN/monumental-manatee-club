package com.greenfoxacademy.foxclubwithsql.services;

import com.greenfoxacademy.foxclubwithsql.models.Manatee;
import com.greenfoxacademy.foxclubwithsql.models.Nutrition;

public interface ManateeService {
  void saveManatee(Manatee manatee);
  Manatee getManateeById(long id);
  void removeManateeById(long id);
  void setFoodAndDrink(long manateeId, Nutrition food, Nutrition drink);
}
