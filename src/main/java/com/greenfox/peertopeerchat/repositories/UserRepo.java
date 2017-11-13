package com.greenfox.peertopeerchat.repositories;

import com.greenfox.peertopeerchat.model.ChatUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<ChatUser,Long> {

}
