package com.example.greenpotback.Post;

import com.example.greenpotback.Post.Comment.Comment;
import com.example.greenpotback.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Column(length = 8191)
    private String content;

    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User authorPost;

    @JsonIgnore
    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

}
