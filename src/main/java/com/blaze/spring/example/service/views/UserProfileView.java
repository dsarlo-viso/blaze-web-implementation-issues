package com.blaze.spring.example.service.views;

import com.blaze.spring.example.domain.UserProfile;
import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.util.UUID;

@CreatableEntityView
@EntityView(UserProfile.class)
public interface UserProfileView {
	@IdMapping("id")
	UUID getId();

	String getFirstName();
	void setFirstName(String firstName);

	String getLastName();
	void setLastName(String lastName);
}
