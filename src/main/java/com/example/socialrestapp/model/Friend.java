package com.example.socialrestapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Friend implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String phone;
    private String imageURL;

    @Column(nullable = false, updatable = false)
    private String friendCode;

    public Friend(Long id, String name, String phone, String imageURL, String friendCode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageURL = imageURL;
        this.friendCode = friendCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFriendCode() {
        return friendCode;
    }

    public void setFriendCode(String friendCode) {
        this.friendCode = friendCode;
    }
}
