package com.greenfox.peertopeerchat.services;

import com.greenfox.peertopeerchat.model.ChatUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private List<ChatUser> userList = new ArrayList<>(Arrays.asList());



  public List<ChatUser> getUserList() {
    return userList;
  }

}
