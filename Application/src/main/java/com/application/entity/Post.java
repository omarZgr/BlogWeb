package com.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id ;

    private String name ;

    @Column(length = 5000)
    private  String content ;

    private  String img ;

    private int likeCount ;

    private int viewCount ;

    private String postedBy ;

    private Date date ;

    @ElementCollection
    private List<String> tags ;


}
