package com.example.greenpotback.Message;

import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserRepository;
import com.example.greenpotback.User.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    private final UserServiceImp userService;

    @Override
    public Message saveMessage(Principal user, Integer receiver, Message message) {
        User sender = userService.getCurrentUser(user);
        User userReceiver = userService.findUserById(receiver);

        message.setSender(sender);
        message.setReceiver(userReceiver);
        return messageRepository.save(message);
    }

    @Override
    public List<User> getAllReceivers(Principal user) {
        User u = userService.getCurrentUser(user);
        List<Integer> usersId = messageRepository.findReceiverDistinctBySender(u);
        List<User> users = new ArrayList<>();
        for(int id: usersId)
            users.add(userRepository.findUserById(id));
        return users;
    }

    @Override
    public List<Message> getUserToUserAll(Principal user, Integer receiverId) {
        User sender = userService.getCurrentUser(user);
        User receiver = userService.findUserById(receiverId);
        return messageRepository.findAllBySenderAndReceiver(sender,receiver);
    }
}
