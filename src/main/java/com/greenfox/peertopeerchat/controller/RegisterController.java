package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.ChatUser;
import com.greenfox.peertopeerchat.model.Log;
import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

  @Autowired
  UserRepo userRepository;

  @Autowired
  MessageRepo chatMessageRepository;


  @RequestMapping("/enter")
  public String register() {
    Log log = new Log("/enter", "REQUEST", "");
      System.out.println(log.toString());
    if (userRepository.count() > 0) {
      return "redirect:/chatapp";
    } else {
      return "enter";
    }
  }
  @PostMapping("/enter/add")
  public String addNewUser(@RequestParam("name") String name) {
    Log log = new Log("/enter/add", "POST", "name=" + name);
      System.out.println(log.toString());
    if (name.isEmpty()) {
      return "redirect:/enter";
    } else {
      userRepository.save(new ChatUser(name));
      return "redirect:/";
    }
  }




}
