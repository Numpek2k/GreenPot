package com.example.greenpotback.Message;

import com.example.greenpotback.User.User;

import java.security.Principal;
import java.util.List;

public interface MessageService {
    Message saveMessage(Principal user, Integer receiver, Message message);

    List<User> getAllReceivers(Principal user);

    List<Message> getUserToUserAll(Principal user, Integer receiverId);
}
