package com.application.controller;


import com.application.entity.Comment;
import com.application.entity.Post;
import com.application.service.Comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CommentController {

    private  final CommentService commentService ;


    @PostMapping("comments/create")
    public ResponseEntity<?> createEntity(@RequestParam Long postId,@RequestParam String postedBy,@RequestBody String content)

    {
        try{
            return  ResponseEntity.ok(commentService.createComment(postId,postedBy,content)) ;
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage())  ;
        }
    }

    @GetMapping("comments/{postId}")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable long postId)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.findByPostId(postId)) ;
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
        }
    }


}
