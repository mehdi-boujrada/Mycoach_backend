package com.pro.Mycoach.services;

import com.pro.Mycoach.data.entities.Posts;
import com.pro.Mycoach.data.repositories.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class PostService {
    @Autowired
    PostsRepo postsRepo;

    public void createPosts(String title, String PostDiscription, Image image) {
        Posts posts = new Posts(title, PostDiscription, image);
        postsRepo.save(posts);
    }
}
