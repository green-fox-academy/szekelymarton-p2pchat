package com.greenfox.peertopeerchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
   long id;

   public String message;
   public String messageBy;

  public ChatMessage() {
  }

  public ChatMessage(String message,String messageBy) {
    this.message = message;
    this.messageBy = messageBy;
  }

  public String getMessageBy() {
    return messageBy;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setMessageBy(String messageBy) {
  }
}
