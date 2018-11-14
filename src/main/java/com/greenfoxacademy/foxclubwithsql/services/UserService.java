package com.greenfoxacademy.foxclubwithsql.services;

import com.greenfoxacademy.foxclubwithsql.models.User;

public interface UserService {

  User getUserById(long id);
  User createUser();
  void saveUser(User user);
  User getUserByUserName(String username);
  void createManateeAddToUser(long userId, String manateeName, boolean isMale);
  void removeManatee(long userId, long manateeId);
}
