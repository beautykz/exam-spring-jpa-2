package com.example.examspringjpa.service;

import com.example.examspringjpa.dto.PostDTO;
import com.example.examspringjpa.model.post.Post;
import com.example.examspringjpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;


    public void addPost(PostDTO postDTO) {
        Post post = new Post();

        post.setDetails(postDTO.getDetails());
        post.setPostdate(postDTO.getPostdate());

        postRepository.save(post);
    }
}
