package com.blaze.spring.example.service.views;

import com.blaze.spring.example.domain.UserProfile;
import com.blazebit.persistence.view.*;

import java.util.List;
import java.util.UUID;

@CreatableEntityView
@UpdatableEntityView
@EntityView(UserProfile.class)
public interface UserProfileView {
	@IdMapping("id")
	UUID getId();

	String getFirstName();
	void setFirstName(String firstName);

	String getLastName();
	void setLastName(String lastName);

	@UpdatableMapping(orphanRemoval = true, cascade = {CascadeType.AUTO, CascadeType.PERSIST})
	List<LinkView> getLinks();
	void setLinks(List<LinkView> links);
}
