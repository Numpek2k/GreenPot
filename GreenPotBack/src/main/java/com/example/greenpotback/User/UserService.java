package com.example.greenpotback.User;

import javax.swing.text.StyledEditorKit;
import java.security.Principal;

public interface UserService {
    User getUser (User user);
    User getCurrentUser(Principal user);
    User findUserByEmail(String email);
    User findUserById(Integer id);
    Boolean isUserFollowingPlant(String email, Integer id);
}
