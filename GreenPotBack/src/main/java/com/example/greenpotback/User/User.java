package com.example.greenpotback.User;

import com.example.greenpotback.Message.Message;
import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.Post.Comment.Comment;
import com.example.greenpotback.Post.Post;
import com.example.greenpotback.User.Role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(length = 4095)
    private String description;

    @ManyToOne
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "sender",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Message> sendMessages = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "receiver",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Message> receivedMessages = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "authorPost",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Post> usersPosts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "authorCom",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Comment> usersComments = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "observed",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "plant_id"))
    private List<Plant> observedPlant = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Plant> createdPlant = new ArrayList<>();

}





