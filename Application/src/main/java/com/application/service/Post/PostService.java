package com.application.service.Post;

import com.application.entity.Post;

import java.util.List;

public interface PostService {


    public Post savePost(Post post) ;
    public List<Post> getAllPosts()  ;

    public Post getPostById(long id)  ;

    public void likePost(long id) ;

    List<Post> findByNameContaining(String name)  ;

}
