package com.pro.Mycoach.controllers;

import com.pro.Mycoach.data.entities.Posts;
import com.pro.Mycoach.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    public boolean createPosts(@RequestBody Posts dto) {
        if (!check(dto))
            return false;

        postService.createPosts(dto.getTitle(), dto.getPostDiscription(), dto.getImage());
        return true;
    }

    private boolean check(Posts dto) {
        return false;
    }
}
