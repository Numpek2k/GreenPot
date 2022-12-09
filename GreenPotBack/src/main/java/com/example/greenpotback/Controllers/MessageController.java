package com.example.greenpotback.Controllers;

import com.example.greenpotback.Message.Message;
import com.example.greenpotback.Message.MessageServiceImp;
import com.example.greenpotback.User.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;
import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceImp messageService;

    @PostMapping("/save")
    public ResponseEntity<Message> saveMessage(Principal user, @RequestParam Integer receiver,
                                               @RequestBody Message message){
        return new ResponseEntity<>(messageService.saveMessage(user, receiver, message), HttpStatus.CREATED);
    }

    @GetMapping("/receivers-all")
    public ResponseEntity<List<User>> getCorrespondents(Principal user){
        return new ResponseEntity<>(messageService.getAllReceivers(user),HttpStatus.OK);
    }

    @GetMapping("/user-to-user-all")
    public ResponseEntity<List<Message>> getUserMessages(Principal user, Integer receiverId){
        return new ResponseEntity<>(messageService.getUserToUserAll(user, receiverId),HttpStatus.OK);
    }
}
