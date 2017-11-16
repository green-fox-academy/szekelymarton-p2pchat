package com.greenfox.p2p.controller;

import com.greenfox.p2p.model.ChatUser;
import com.greenfox.p2p.model.Client;
import com.greenfox.p2p.model.Message;
import com.greenfox.p2p.model.ToBeRecieved;
import com.greenfox.p2p.repositories.MessageRepo;
import com.greenfox.p2p.repositories.UserRepo;
import com.greenfox.p2p.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import java.sql.Timestamp;


import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

  @Autowired
  UserRepo chatUserRepo;

  @Autowired
  ChatService chatService;

  @Autowired
  MessageRepo messageRepo;

  @GetMapping({"", "/"})
  public String index(HttpServletRequest request, Model model) {
    chatService.checkEnvironment(request);
    model.addAttribute("message", new Message());
    if (size(messageRepo.findAll()) > 0) {
      model.addAttribute("messages", messageRepo.findAll());
    }
    if (chatUserRepo.findAllByIdIsGreaterThan(0).size() > 0) {
      model.addAttribute("current", chatUserRepo.findOne(chatUserRepo.smallest()));
      return "index";
    }
    return "redirect:/enter";
  }

  @GetMapping("/enter")
  public String enter(HttpServletRequest request, Model model) {
    chatService.checkEnvironment(request);
    model.addAttribute("chatuser", new ChatUser());
    return "enter";
  }

  @PostMapping("/save")
  public String save(HttpServletRequest request, @ModelAttribute ChatUser chatuser, Model model) {
    chatService.checkEnvironment(request);
    model.addAttribute("chatuser", new ChatUser());
    if (chatUserRepo.findChatUserByName(chatuser.getName()).size() > 0) {
      model.addAttribute("error", "User with this name already exists.");
      return "enter";
    } else if (chatuser.getName().equals("")) {
      model.addAttribute("errorTwo", "Please enter a name for the user.");
      return "enter";
    } else {
      chatUserRepo.save(chatuser);
      return "redirect:/";
    }
  }

  @PostMapping("/update")
  public String saveNewName(HttpServletRequest request, @ModelAttribute ChatUser current,
      Model model) {
    chatService.checkEnvironment(request);
    model.addAttribute("current", chatUserRepo.findOne(chatUserRepo.smallest()));

    if (current.getName().equals("")) {
      model.addAttribute("error", "Please enter a name for the user.");
      return "index";
    }
    chatUserRepo.save(current);
    return "redirect:/";
  }

  @PostMapping(value = "/savemessage")
  public String saveNewMessage(HttpServletRequest request, @ModelAttribute Message message,
      Model model) {
    chatService.checkEnvironment(request);
    model.addAttribute("message", new Message());
    message.setUsername(chatUserRepo.findOne(chatUserRepo.smallest()).getName());
    message.setId(message.randomId());
    message.setTimestamp(new Timestamp(System.currentTimeMillis()));
    chatService
        .sendMessage(new ToBeRecieved(new Client(System.getenv("CHAT_APP_UNIQUE_ID")), message));
    return "redirect:/";
  }
}