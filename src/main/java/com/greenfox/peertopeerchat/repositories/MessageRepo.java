package com.greenfox.peertopeerchat.repositories;

import com.greenfox.peertopeerchat.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<ChatMessage,Long> {

}
