package com.example.greenpotback.User;

import java.security.Principal;

public interface UserService {
    User getUser (User user);
    User saveUser(User user);
    User getCurrentUser(Principal user);
    User findUserByEmail(String email);
}
