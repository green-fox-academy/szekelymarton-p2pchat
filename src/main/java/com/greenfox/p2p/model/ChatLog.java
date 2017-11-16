package com.greenfox.p2p.model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatLog {

//    2017-05-16 21:47:19.040 INFO Request /message POST text=apple

  String date;
  String level; //info vagy error
  String method;
  String param;
  String path;

  public ChatLog() {
  }

  public ChatLog(HttpServletRequest h) {
    this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    this.level = System.getenv("CHAT_APP_LOGLEVEL");
    this.method = h.getMethod();
    this.path = h.getServletPath();
    this.param = h.getQueryString();
    int logId;
  }

  @Override
  public String toString() {
    return date + " " + level + " " + path + " " + method + " " + param;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}