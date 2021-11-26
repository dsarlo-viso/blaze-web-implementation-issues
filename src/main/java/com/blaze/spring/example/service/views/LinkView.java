package com.blaze.spring.example.service.views;

import com.blaze.spring.example.domain.Link;
import com.blaze.spring.example.domain.UserProfile;
import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.UpdatableEntityView;

import java.util.UUID;

@CreatableEntityView
@UpdatableEntityView
@EntityView(Link.class)
public interface LinkView {
    @IdMapping("id")
    UUID getId();

    String getName();
    void setName(String name);

    String getUrl();
    void setUrl(String url);
}
