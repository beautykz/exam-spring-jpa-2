package com.example.examspringjpa.model.location;


import com.example.examspringjpa.model.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Location {
    private String id;
    private String name;

    private List<User> users;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="location")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
