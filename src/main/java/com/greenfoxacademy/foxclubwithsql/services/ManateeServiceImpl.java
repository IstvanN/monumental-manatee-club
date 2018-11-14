package com.greenfoxacademy.foxclubwithsql.services;

import com.greenfoxacademy.foxclubwithsql.models.Manatee;
import com.greenfoxacademy.foxclubwithsql.models.Nutrition;
import com.greenfoxacademy.foxclubwithsql.repositories.ManateeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManateeServiceImpl implements ManateeService {


  private final ManateeRepository manateeRepository;

  @Autowired
  public ManateeServiceImpl(ManateeRepository manateeRepository) {
    this.manateeRepository = manateeRepository;
  }

  @Override
  public void saveManatee(Manatee manatee) {
    manateeRepository.save(manatee);
  }

  @Override
  public Manatee getManateeById(long id) {
    return manateeRepository.findById(id).orElse(null);
  }

  @Override
  public void removeManateeById(long id) {
    manateeRepository.deleteById(id);
  }

  @Override
  public void setFoodAndDrink(long manateeId, Nutrition food, Nutrition drink) {
    Manatee manatee = manateeRepository.findById(manateeId).orElse(null);
    manatee.setCurrentFood(food);
    manatee.setCurrentDrink(drink);
    manateeRepository.save(manatee);
  }
}
