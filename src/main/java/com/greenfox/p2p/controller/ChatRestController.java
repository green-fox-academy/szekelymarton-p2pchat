package com.greenfox.p2p.controller;

import com.greenfox.p2p.model.Status;
import com.greenfox.p2p.model.ToBeRecieved;
import com.greenfox.p2p.repositories.MessageRepo;
import com.greenfox.p2p.repositories.UserRepo;
import com.greenfox.p2p.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ChatRestController {


  @Autowired
  UserRepo chatUserRepo;

  @Autowired
  ChatService chatService;

  @Autowired
  MessageRepo messageRepo;

  @GetMapping(value="/index")
  public void index(HttpServletRequest request){
    chatService.checkEnvironment(request);
  }

  @CrossOrigin("*")
  @PostMapping(value = "/api/message/receive")
  public Object getsMessage(@RequestBody ToBeRecieved toBeRecieved, HttpServletRequest request){
    chatService.checkEnvironment(request);
    if (chatService.checkFields(toBeRecieved).equals("")){
      messageRepo.save(toBeRecieved.getMessage());
      return "{\"status\": \"ok\"}";
    }
    else {
      return new ResponseEntity(new Status("error", "Missing field(s):" + chatService.checkFields(toBeRecieved)), HttpStatus.BAD_REQUEST);
    }
  }
}