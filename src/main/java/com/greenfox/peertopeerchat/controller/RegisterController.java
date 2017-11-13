package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.ChatUser;
import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

  @Autowired
  UserRepo userRepository;

  @Autowired
  MessageRepo chatMessageRepository;

  @RequestMapping("/enter")
  public String register(Model model) {
    model.addAttribute("enter", new ChatUser());
    return "enter";
  }

  @PostMapping("/update")
  public Object userRegistration(Model model) {
    return "redirect:/chatapp";
  }

}
