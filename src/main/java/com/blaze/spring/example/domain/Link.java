package com.blaze.spring.example.domain;

import javax.persistence.*;
import java.util.UUID;

@Embeddable
@Table(name = "link")
public class Link {
    private String name;
    private String url;

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
}
