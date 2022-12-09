package com.example.greenpotback.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.email = ?1")
    User findUserByEmail(String email);
    @Query("select (count(u) > 0) from User u where u.email = ?1")
    Boolean existsByEmail(String email);
    @Query("select (count(u) > 0) from User u inner join u.observedPlant observedPlant where u.email = ?1 and observedPlant.id = ?2")
    Boolean existsAllByEmailAndObservedPlantId(String email, Integer id);
    @Query("select u from User u where u.id = ?1")
    User findUserById(Integer id);

    @Query("select u from User u where u.id in ?1")
    List<User> findAllUserByIdIn(List<Integer> id);

}
