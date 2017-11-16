package com.greenfox.p2p.model;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message {
  String username;
  String text;
  Timestamp timestamp;

  @Id
  Integer id;

  public Message() {

  }

  public Message(String username, String text, Timestamp timestamp, Integer id) {
    this.username = username;
    this.text = text;
    this.timestamp = timestamp;
    this.id = randomId();
  }


  public Integer randomId(){
    return (int)(Math.random() * 9999999 + 1000000);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}