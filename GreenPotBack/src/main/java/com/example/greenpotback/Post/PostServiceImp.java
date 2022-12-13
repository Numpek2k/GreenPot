package com.example.greenpotback.Post;

import com.example.greenpotback.Controllers.ControllerConst;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Post.Comment.Comment;
import com.example.greenpotback.Post.Comment.CommentRepository;
import com.example.greenpotback.User.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final EntityManager entityManager;

    @Override
    public List<Post> getAllPostOrderByDate() {
        return postRepository.findPostOrderByDate();
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Comment> getCommentByPostId(Integer id) {
        return commentRepository.findAllByPostId(id);
    }

    @Override
    public List<Post> getPostByAuthor(Integer id) {
        return postRepository.findPostsByAuthorPostId(id);
    }

    @Override
    public List<Post> getLatestPostWithLimit() {
        return postRepository.findFirst5ByOrderByDateDesc();
    }

    @Override
    public void addCommentToPost(Comment comment, Integer id, Principal user) {
        comment.setAuthorCom(userRepository.findUserByEmail(user.getName()));
        comment.setPost(postRepository.findPostById(id));
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public Integer savePost(Post post, Principal user) {
        post.setAuthorPost(userRepository.findUserByEmail(user.getName()));
        entityManager.persist(post);
        return post.getId();
    }

    @Override
    public void uploadPhoto(MultipartFile file, Integer id) {
        Path uploadPath = Paths.get(ControllerConst.POST_IMAGE_SAVE_PATH + id);
        Post post = postRepository.findPostById(id);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String fileName = new Date().getTime() + file.getOriginalFilename();

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        post.setImage(ControllerConst.POST_IMAGES_PATH + id + '/' + fileName);
        postRepository.save(post);

    }
}
