package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.ChatUser;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

  @Autowired
  private UserRepo userRepo;

  @RequestMapping(value = "/enter",method = RequestMethod.GET)
  public String register(Model model) {
    model.addAttribute("newuser", new ChatUser());
    return "enter";
  }

  @PostMapping("/enteruser")
  public String addNewChatUser(@ModelAttribute("newuser") ChatUser newuser, Model model) {
    model.addAttribute("newuser", new ChatUser());
    userRepo.save(newuser);
    return "redirect:/";
  }
}

