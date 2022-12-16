package com.example.greenpotback.Controllers;

import com.example.greenpotback.Message.Message;
import com.example.greenpotback.Message.MessageRepository;
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

@Controller
@AllArgsConstructor
public class SocketController {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{sender}/{receiver}")
//    @SendToUser("/topic/chat")
    public String chat(Principal principal, @DestinationVariable Integer sender, @DestinationVariable Integer receiver, Message message){
        message.setReceiver(userRepository.findUserById(receiver));
        message.setSender(userRepository.findUserById(sender));
        messageRepository.save(message);
//        simpMessagingTemplate.convertAndSendToUser();
//        messagingTemplate.convertAndSendToUser(message.getToUser(), "/queue/reply", greeting);/
        simpMessagingTemplate.convertAndSend("/topic/messages/" + receiver, message);
        return message.getContent();
    }
}
