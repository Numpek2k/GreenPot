package com.example.greenpotback.Controllers;

import com.example.greenpotback.Message.Message;
import com.example.greenpotback.Message.MessageRepository;
import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Collections;

@Controller
@AllArgsConstructor
public class SocketController {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{sender}/{receiver}")
    public String chat(@DestinationVariable Integer sender, @DestinationVariable Integer receiver, Message message){
        User userRec = userRepository.findUserById(receiver);
        User userSend = userRepository.findUserById(sender);
        message.setReceiver(userRec);
        message.setSender(userSend);
        messageRepository.save(message);

        simpMessagingTemplate.convertAndSendToUser(chatID(userRec.getId(),userSend.getId()),
                "/queue/reply", message, Collections.singletonMap("receiver", userRec.getId()));

        return message.getContent();
    }

    private String chatID(int a, int b){
        if(a > b)
            return "chatU"+b+"U"+a;
        return "chatU"+a+"U"+b;
    }
}
