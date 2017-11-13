package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.Log;
import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import com.greenfox.peertopeerchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @Autowired
  private MessageRepo messageRepo;

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private UserService userService;


  @RequestMapping("/")
  public String main(Model model) {
    Log log = new Log("/", "GET", "");
    System.out.println(log.toString());
    if (userRepo.count() == 0) {
      return "redirect:/enter";
    } else {
      model.addAttribute("userName", userRepo.findOne(1L).getName());
      return "chatapp";
    }
  }
}

