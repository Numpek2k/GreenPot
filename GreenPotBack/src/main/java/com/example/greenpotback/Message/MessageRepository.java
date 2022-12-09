package com.example.greenpotback.Message;

import com.example.greenpotback.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "select receiver_id, max(ids.date) as max from (select receiver_id,date from message " +
            "where sender_id =4 union select sender_id,date from message as m " +
            "where receiver_id = 4 order by date desc) as ids group by receiver_id order by max desc",
            nativeQuery = true)
    List<Integer> findReceiverDistinctBySender(User user);

//    select distinct receiver_id from message where sender_id =4 union
//    select distinct sender_id from message as m where receiver_id = 4

//    select * from "user" as u where u.id in
//            (select distinct receiver_id from message where sender_id =4 union
//                    select distinct sender_id from message as m where receiver_id = 4)

    @Query("select m from Message m where m.sender = ?1 and m.receiver = ?2 " +
            "or m.sender = ?2 and m.receiver = ?1 order by m.date")
    List<Message> findAllBySenderAndReceiver(User sender, User receiver);
}
