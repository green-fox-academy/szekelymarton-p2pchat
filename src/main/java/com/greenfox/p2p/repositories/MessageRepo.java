package com.greenfox.p2p.repositories;

import com.greenfox.p2p.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message,Integer> {

}
