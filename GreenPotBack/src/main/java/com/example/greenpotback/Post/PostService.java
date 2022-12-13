package com.example.greenpotback.Post;

import com.example.greenpotback.Post.Comment.Comment;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

public interface PostService {
    List<Post> getAllPostOrderByDate();
    Post getPostById(Integer id);
    List<Comment> getCommentByPostId(Integer id);
    List<Post> getPostByAuthor(Integer id);
    List<Post> getLatestPostWithLimit();
    void addCommentToPost(Comment comment, Integer id, Principal user);

    Integer savePost(Post post, Principal user);

    void uploadPhoto(MultipartFile file, Integer id);
}
