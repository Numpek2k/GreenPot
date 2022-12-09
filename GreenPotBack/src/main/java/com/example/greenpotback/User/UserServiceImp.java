package com.example.greenpotback.User;

import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.User.Role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public User getCurrentUser(Principal user) {
        String email = user.getName();
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Boolean isUserFollowingPlant(String email, Integer id) {
        return userRepository.existsAllByEmailAndObservedPlantId(email, id);
    }

    public void addFollow(Plant plant, User user){
        user.getObservedPlant().add(plant);
        userRepository.save(user);
    }

    public void removeFollow(Plant plant, User user){
        user.getObservedPlant().remove(plant);
        userRepository.save(user);
    }



}
