package com.greenfox.peertopeerchat.controller;

import com.greenfox.peertopeerchat.model.ChatMessage;
import com.greenfox.peertopeerchat.repositories.MessageRepo;
import com.greenfox.peertopeerchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @Autowired
  private MessageRepo messageRepo;

  @Autowired
  private UserRepo userRepo;

  @PostMapping("/createmessage")
  public String createMessage (@ModelAttribute("newchatmessage") ChatMessage newchatmessage, Model model) {
    newchatmessage.setMessageBy("Marci");
    messageRepo.save(newchatmessage);
    return "redirect:/";
  }
  @GetMapping("/")
  public String chatappMain(Model model) {
    model.addAttribute("newchatmessage", new ChatMessage());
    return "chatapp";
  }

  @RequestMapping({"/chatapp","/",""})
  public String indexPage(Model model) {
    model.addAttribute("users", userRepo.findAll());
    model.addAttribute("newchatmessage", new ChatMessage());
    model.addAttribute("messages", messageRepo.findAll());
    return "chatapp";
  }
  @PostMapping("/addMessage")
  public String addChatMessage(@ModelAttribute ChatMessage newchatmessage, Model model) {
    model.addAttribute("newchatmessage",newchatmessage);
    newchatmessage.setMessageBy(userRepo.findOne(1L).toString());
    messageRepo.save(newchatmessage);
    return "redirect:/";
  }
}


