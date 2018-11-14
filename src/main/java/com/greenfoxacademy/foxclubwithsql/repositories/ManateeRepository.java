package com.greenfoxacademy.foxclubwithsql.repositories;

import com.greenfoxacademy.foxclubwithsql.models.Manatee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManateeRepository extends CrudRepository<Manatee, Long> {
}
