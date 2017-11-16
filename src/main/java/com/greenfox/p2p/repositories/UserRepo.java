package com.greenfox.p2p.repositories;

import com.greenfox.p2p.model.ChatUser;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<ChatUser,Integer> {
  List<ChatUser> findChatUserByName(String name);
  List<ChatUser> findAllByIdIsGreaterThan(int a);

  @Query(value="SELECT MIN(id) FROM chatusers", nativeQuery = true)
  Integer smallest();


}
