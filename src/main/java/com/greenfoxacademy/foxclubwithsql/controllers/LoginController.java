package com.greenfoxacademy.foxclubwithsql.controllers;

import com.greenfoxacademy.foxclubwithsql.models.User;
import com.greenfoxacademy.foxclubwithsql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private final UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = {"", "/login"})
  public String showLoginPage() {
    return "login/login";
  }

  @PostMapping("/login")
  public String logInUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
    User user = userService.getUserByUserName(username);

    if (user == null) {
      model.addAttribute("notExistingUser", true);
      return "login/login";
    }

    if (password.equals(user.getPassword())) {
      return "redirect:/club/" + user.getId();
    }

    model.addAttribute("validationFailed", true);
    return "login/login";
  }

  @GetMapping("/signup")
  public String showSignupPage(Model model) {
    User newUser = userService.createUser();
    model.addAttribute("user", newUser);
    return "login/sign-up";
  }

  @PostMapping("/signup")
  public String signUp(@ModelAttribute User user, @RequestParam("secondPassword") String secondPassword, Model model) {
    if (user.getPassword().equals(secondPassword)) {
      userService.saveUser(user);
      return "redirect:/login";
    }

    model.addAttribute("wrongPassword", true);
    return "login/sign-up";
  }
}
