package com.application.service.Comment;

import com.application.entity.Comment;
import com.application.entity.Post;
import com.application.repositort.CommentRepository;
import com.application.repositort.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements  CommentService {

    private final CommentRepository commentRepository ;
    private final PostRepository postRepository ;


    public Comment createComment(long postId,String postedBy,String content)
    {
        Optional<Post> optionalPost = postRepository.findById(postId) ;

        if (optionalPost.isPresent())
        {
            Comment comment = new Comment()  ;

            comment.setPost(optionalPost.get()) ;
            comment.setId(postId);
            comment.setCreatedAt(new Date());
            comment.setContent(content);
            comment.setPostedBy(postedBy);

           return commentRepository.save(comment) ;
        }
        else
            throw  new EntityNotFoundException("Post not found")  ;
    }

    public List<Comment> findByPostId(long id)
    {
        return commentRepository.findByPostIdOrderByCreatedAtDesc(id)  ;
    }
}
