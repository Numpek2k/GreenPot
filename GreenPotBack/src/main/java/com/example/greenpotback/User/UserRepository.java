package com.example.greenpotback.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
