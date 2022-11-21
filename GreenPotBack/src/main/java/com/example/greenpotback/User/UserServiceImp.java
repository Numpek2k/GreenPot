package com.example.greenpotback.User;

import com.example.greenpotback.User.Role.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(mail);
        if (user == null) throw new UsernameNotFoundException("User not found in the database");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }


    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole(roleRepository.findByName("USER"));

        return userRepository.save(user);
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


}
