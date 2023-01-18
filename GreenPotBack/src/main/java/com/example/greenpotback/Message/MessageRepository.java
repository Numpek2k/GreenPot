package com.example.greenpotback.Message;

import com.example.greenpotback.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "select distinct case when m.sender = ?1 then m.receiver else m.sender " +
            "end as comb, max(m.date) as maxx from Message as m where ?1 in (m.sender, m.receiver) " +
            "group by comb order by maxx desc")
    List<User> findReceiverDistinctBySender(User user);

    @Query("select m from Message m where m.sender = ?1 and m.receiver = ?2 " +
            "or m.sender = ?2 and m.receiver = ?1 order by m.date")
    List<Message> findAllBySenderAndReceiver(User sender, User receiver);
}
