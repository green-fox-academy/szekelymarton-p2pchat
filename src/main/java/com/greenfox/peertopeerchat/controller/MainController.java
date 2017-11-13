package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.Log;
import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @Autowired
  private MessageRepo messageRepo;

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/")
  public String main(Model model) {
    Log log = new Log("/","GET","");
    model.addAttribute("listUsers",userRepo.findAll());
        return "chatapp";
  }
  @PostMapping("/update")
  public String updateUser(Model model,@PathVariable String name) {
    model.addAttribute("name",name);
    return "chatapp";
  }
  //Update for Heroku testing
//Update for Heroku testing//Update for Heroku testing//Update for Heroku testing//Update for Heroku testing
}
