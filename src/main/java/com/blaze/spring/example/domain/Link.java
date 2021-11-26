package com.blaze.spring.example.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "link")
public class Link {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    private String name;
    private String url;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserProfile userProfile;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
