package com.greenfoxacademy.foxclubwithsql.services;

import com.greenfoxacademy.foxclubwithsql.models.Nutrition;
import com.greenfoxacademy.foxclubwithsql.models.enums.NutritionType;
import com.greenfoxacademy.foxclubwithsql.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionServiceImpl implements NutritionService {

  private final NutritionRepository nutritionRepository;

  @Autowired
  public NutritionServiceImpl(NutritionRepository nutritionRepository) {
    this.nutritionRepository = nutritionRepository;
  }

  @Override
  public List<Nutrition> getAllFoods() {
    return nutritionRepository.findAllByType(NutritionType.FOOD);
  }

  @Override
  public List<Nutrition> getAllDrinks() {
    return nutritionRepository.findAllByType(NutritionType.DRINK);
  }

  @Override
  public Nutrition getFoodById(long id) {
    return nutritionRepository.findById(id).orElse(null);
  }

  @Override
  public Nutrition getDrinkById(long id) {
    return nutritionRepository.findById(id).orElse(null);
  }

  @Override
  public void saveNutrition(Nutrition nutrition) {
    nutritionRepository.save(nutrition);
  }
}
