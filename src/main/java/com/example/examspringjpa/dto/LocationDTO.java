package com.example.examspringjpa.dto;

import com.example.examspringjpa.model.user.User;

import java.util.List;

public class LocationDTO {
    private String id;
    private String name;

    private List<UserDTO> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
