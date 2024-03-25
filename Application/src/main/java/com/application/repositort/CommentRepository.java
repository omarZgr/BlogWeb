package com.application.repositort;


import com.application.entity.Comment;
import com.application.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostIdOrderByCreatedAtDesc(long id)  ;
}
