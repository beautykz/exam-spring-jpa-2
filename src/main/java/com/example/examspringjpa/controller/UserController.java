package com.example.examspringjpa.controller;

import com.example.examspringjpa.dto.PostDTO;
import com.example.examspringjpa.dto.UserDTO;
import com.example.examspringjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/addUser")
    public HttpStatus addUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return HttpStatus.OK;
    }

    @GetMapping("/user/find/{id}")
    public UserDTO findUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user/findAll")
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/user/{id}")
    public HttpStatus updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        userService.updateUserById(id, userDTO);
        return HttpStatus.OK;
    }

    @GetMapping("/user/post/{id}")
    public List<PostDTO> getPosts(@PathVariable String id) {
        return userService.getPosts(id);
    }
}
