package com.example.greenpotback.Controllers;

import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/getcurrent")
    public ResponseEntity<User> findCurrentUser(Principal user) {
        log.info("USER: {}", user);
        return ResponseEntity.ok().body(userServiceImp.getCurrentUser(user));
    }
}
