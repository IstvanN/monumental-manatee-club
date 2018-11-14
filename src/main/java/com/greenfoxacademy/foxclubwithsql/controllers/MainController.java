package com.greenfoxacademy.foxclubwithsql.controllers;

import com.greenfoxacademy.foxclubwithsql.models.User;
import com.greenfoxacademy.foxclubwithsql.services.ManateeService;
import com.greenfoxacademy.foxclubwithsql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club")
public class MainController {

  private final UserService userService;
  private final ManateeService manateeService;

  @Autowired
  public MainController(UserService userService, ManateeService manateeService) {
    this.userService = userService;
    this.manateeService = manateeService;
  }

  @GetMapping("/{id}")
  public String showIndex(@PathVariable("id") long userId, Model model) {
    User user = userService.getUserById(userId);
    if (user == null) {
      return "redirect:/login";
    }

    model.addAttribute("user", user);
    return "index";
  }

  @GetMapping("/{id}/create")
  public String showManateeCreationCenter(@PathVariable("id") long userId, Model model) {
    model.addAttribute("user", userService.getUserById(userId));
    return "manatee/create-manatee";
  }

  @PostMapping("/{id}/create")
  public String createManatee(@PathVariable("id") long userId, @RequestParam("manateeName") String manateeName, @RequestParam("gender") boolean isMale) {
    if (isMale) {
      userService.createManateeAddToUser(userId, manateeName, true);
    } else {
      userService.createManateeAddToUser(userId, manateeName, false);
    }
    return "redirect:/club/" + userId;
  }

  @PostMapping("/{id}/delete")
  public String deleteManatee(@PathVariable("id") long userId, @RequestParam("manateeId") long manateeId) {
    userService.removeManatee(userId, manateeId);
    manateeService.removeManateeById(manateeId);
    return "redirect:/club/" + userId;
  }

}
