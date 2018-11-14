package com.greenfoxacademy.foxclubwithsql.repositories;

import com.greenfoxacademy.foxclubwithsql.models.Nutrition;
import com.greenfoxacademy.foxclubwithsql.models.enums.NutritionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionRepository extends CrudRepository<Nutrition, Long> {
  List<Nutrition> findAllByType(NutritionType type);
}
