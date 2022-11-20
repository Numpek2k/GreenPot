package com.example.greenpotback.User.Role;

import com.example.greenpotback.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "role",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<User> userList = new ArrayList<>();
}
