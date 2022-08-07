package com.example.greenpotback.Post.Comment;

import com.example.greenpotback.Post.Post;
import com.example.greenpotback.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User authorCom;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
