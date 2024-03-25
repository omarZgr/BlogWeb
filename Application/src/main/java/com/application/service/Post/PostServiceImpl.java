package com.application.service.Post;


import com.application.entity.Post;
import com.application.repositort.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository ;

    public List<Post> findByNameContaining(String name)
    {
        return  postRepository.findByNameContaining(name)  ;
    }

    public Post savePost(Post post)
    {
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepository.save(post) ;
    }

    public List<Post> getAllPosts()
    {
        return postRepository.findAll() ;
    }

    public Post getPostById(long id)
    {
        Optional<Post> optionalPost = postRepository.findById(id) ;

        if (optionalPost.isPresent())
        {
            Post post = optionalPost.get()  ;
            post.setViewCount(post.getViewCount() + 1);
            return  postRepository.save(post) ;
        }
        else
            throw  new EntityNotFoundException("Post not found with id - "+id)  ;
    }

    public void likePost(long id)
    {
        Optional<Post> optionalPost = postRepository.findById(id) ;

        if (optionalPost.isPresent())
        {
            Post post = optionalPost.get()  ;
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post) ;
        }
        else
            throw  new EntityNotFoundException("Post not found")  ;
    }

}
