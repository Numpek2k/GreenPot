package com.example.greenpotback.Controllers;

import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.PlantServiceImp;
import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    private final PlantServiceImp plantService;

    @GetMapping("/getcurrent")
    public ResponseEntity<User> findCurrentUser(Principal user) {
        if(user == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body(userServiceImp.getCurrentUser(user));
    }

    @GetMapping("/by-id")
    public ResponseEntity<User> findUserById(@RequestParam Integer id){
        User user = userServiceImp.findUserById(id);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/is-following-plant")
    public ResponseEntity<Boolean> isUserFollowingPlant(Principal user, @RequestParam Integer id){
        return new ResponseEntity<>(userServiceImp.isUserFollowingPlant(user.getName(),id), HttpStatus.OK);
    }

    @PostMapping("/follow-plant")
    public ResponseEntity<Boolean> followPlant(Principal user, @RequestParam Integer id){
        User u = userServiceImp.findUserByEmail(user.getName());
        Plant plant = plantService.findPlantByID(id);
        userServiceImp.addFollow(plant,u);

        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @DeleteMapping("/un-follow-plant")
    public ResponseEntity<Boolean> unFollowPlant(Principal user, @RequestParam Integer id){
        User u = userServiceImp.findUserByEmail(user.getName());
        Plant plant = plantService.findPlantByID(id);
        userServiceImp.removeFollow(plant,u);

        return new ResponseEntity<>(false,HttpStatus.OK);
    }
}
