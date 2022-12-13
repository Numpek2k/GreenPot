package com.example.greenpotback.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.id = ?1")
    Post findPostById(Integer id);

    @Query("select p from Post p order by p.date desc")
    List<Post> findPostOrderByDate();

    @Query("select p from Post p where p.authorPost.id = ?1")
    List<Post> findPostsByAuthorPostId(Integer id);

    List<Post> findFirst5ByOrderByDateDesc();
}
