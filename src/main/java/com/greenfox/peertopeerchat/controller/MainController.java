package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @Autowired
  private MessageRepo messageRepo;

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/")
  public String main(Model model) {
        return "chatapp";
  }
}
