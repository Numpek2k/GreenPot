package com.example.greenpotback.Controllers;

import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Post.Comment.Comment;
import com.example.greenpotback.Post.Post;
import com.example.greenpotback.Post.PostService;
import com.example.greenpotback.Post.PostServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostServiceImp postService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllNewestPost(){
        return new ResponseEntity<>(postService.getAllPostOrderByDate(),HttpStatus.OK);
    }

    @GetMapping("/by-id")
    public ResponseEntity<Post> getPostById(@RequestParam Integer id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @GetMapping("/latest-limit")
    public ResponseEntity<List<Post>> getLatestPostWithLimit(){
        return new ResponseEntity<>(postService.getLatestPostWithLimit(),HttpStatus.OK);
    }

    @GetMapping("/comment-by-post")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@RequestParam Integer id){
        return new ResponseEntity<>(postService.getCommentByPostId(id),HttpStatus.OK);
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<Post>> getPostByAuthor(@RequestParam Integer id){
        return new ResponseEntity<>(postService.getPostByAuthor(id),HttpStatus.OK);
    }

    @PostMapping("/add-comment")
    public ResponseEntity<?> addCommentToPost(Principal user, @RequestBody Comment comment, @RequestParam Integer id){
        postService.addCommentToPost(comment, id, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> savePost(@RequestBody Post post, Principal user){
        return new ResponseEntity<>(postService.savePost(post,user),HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file, @RequestParam Integer id){
        postService.uploadPhoto(file,id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
