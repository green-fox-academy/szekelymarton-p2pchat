package com.greenfox.p2p.services;

import com.greenfox.p2p.model.ChatLog;
import com.greenfox.p2p.model.Status;
import com.greenfox.p2p.model.ToBeRecieved;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;

@Service
public class ChatService {

  public void checkEnvironment(HttpServletRequest request){
//    if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")){
      System.out.println(new ChatLog(request));
//    } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")){
      System.err.println(new ChatLog(request));
    }


  public String checkFields(ToBeRecieved toBeRecieved){
    StringBuilder sb = new StringBuilder();
    sb.append("");

    if (toBeRecieved.getMessage().getUsername() == null || toBeRecieved.getMessage().getUsername().isEmpty()){
      sb.append("message.userName");
    } if (toBeRecieved.getMessage().getText() == null || toBeRecieved.getMessage().getText().isEmpty()) {
      sb.append(", ");
      sb.append("message.text");
    } if (toBeRecieved.getMessage().getTimestamp() == null){
      sb.append(", ");
      sb.append("message.timestamp");
    } if (toBeRecieved.getMessage().getId() == null ){
      sb.append(", ");
      sb.append("message.messageId");
    }  if (toBeRecieved.getClient() == null || toBeRecieved.getClient().getId() == null  || toBeRecieved.getClient().getId().isEmpty()) {
      sb.append(", ");
      sb.append("client.id");
    }
    return sb.toString();
  }

  public void sendMessage(ToBeRecieved toBeRecieved){
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<ToBeRecieved> httpent = new HttpEntity<>(toBeRecieved);
    Status s = restTemplate.postForObject(System.getenv("CHAT_APP_PEER_ADDRESSS"),httpent, Status.class);
  }
}