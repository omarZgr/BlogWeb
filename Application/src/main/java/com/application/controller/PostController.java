package com.application.controller;

import com.application.entity.Post;
import com.application.service.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;


    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post)
    {
        try {
            Post createPost = postService.savePost(post) ;
            return ResponseEntity.status(HttpStatus.CREATED).body(createPost) ;
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()  ;
        }
    }


    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts()
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts()) ;
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
        }


    }


    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable long postId)
    {
        try {
            Post post = postService.getPostById(postId) ;
            return ResponseEntity.ok(post) ;        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body((e.getMessage())) ;
        }
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable long postId)
    {
        try {
            postService.likePost(postId); ;
            return ResponseEntity.ok(new String[]{"Posted liked successfully"}) ;        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body((e.getMessage())) ;
        }
    }



    @GetMapping("search/{name}")
    public ResponseEntity<List<Post>> searchByName(@PathVariable  String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.findByNameContaining(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

