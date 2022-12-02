package com.example.examspringjpa.model.post;

import com.example.examspringjpa.model.user.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Post {
    private String id;
    private String postdate;
    private User user;
    private String details;


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
    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(nullable = false)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
