package com.application.service.Comment;

import com.application.entity.Comment;

import java.util.List;

public interface CommentService {

    public Comment createComment(long postId, String postedBy, String content) ;
    public List<Comment> findByPostId(long id) ;

}
