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

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceImp.saveUser(user));
    }

    @GetMapping("/getcurrent")
    public ResponseEntity<User> findCurrentUser(Principal user) {
        log.info("USER: {}", user);
        return ResponseEntity.ok().body(userServiceImp.getCurrentUser(user));
    }
}
