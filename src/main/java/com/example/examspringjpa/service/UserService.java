package com.example.examspringjpa.service;

import com.example.examspringjpa.dto.PostDTO;
import com.example.examspringjpa.dto.UserDTO;
import com.example.examspringjpa.exception.ResourceNotFoundException;
import com.example.examspringjpa.model.post.Post;
import com.example.examspringjpa.model.user.User;
import com.example.examspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<UserDTO> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();


        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public UserDTO findUserById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ResourceNotFoundException();
        }
        User user = optionalUser.get();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        return userDTO;
    }

    public List<PostDTO> getPosts(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        User user = userOptional.get();
        List<Post> posts = user.getPosts();
        List<PostDTO> postDTOS = new ArrayList<>();

        for (Post post: posts) {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setDetails(post.getDetails());
            postDTO.setPostdate(post.getPostdate());
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    public void deleteUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        User user = userOptional.get();
        userRepository.delete(user);
    }

    public void updateUserById(String id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }

        User user = userOptional.get();
        user.setLastname(userDTO.getLastname());
        user.setFirstname(userDTO.getFirstname());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
    }

    public void createUser(UserDTO userDTO) {

        User user = new User();

        user.setEmail(userDTO.getEmail());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        userRepository.save(user);
    }
}
