package com.example.examspringjpa.controller;

import com.example.examspringjpa.dto.PostDTO;
import com.example.examspringjpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/add")
    public HttpStatus addPost(@RequestBody PostDTO postDTO) {
        postService.addPost(postDTO);
        return HttpStatus.OK;
    }
}
