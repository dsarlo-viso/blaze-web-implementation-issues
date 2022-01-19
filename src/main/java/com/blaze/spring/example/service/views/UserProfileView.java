package com.blaze.spring.example.service.views;

import com.blaze.spring.example.domain.UserProfile;
import com.blazebit.persistence.view.*;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.UUID;

@CreatableEntityView
@UpdatableEntityView(mode = FlushMode.PARTIAL)
@EntityView(UserProfile.class)
public interface UserProfileView {
	@IdMapping("id")
	UUID getId();

	String getFirstName();
	void setFirstName(String firstName);

	String getLastName();
	void setLastName(String lastName);

	@Mapping(fetch = FetchStrategy.MULTISET)
	@UpdatableMapping(orphanRemoval = true, cascade = {CascadeType.AUTO, CascadeType.PERSIST})
	List<LinkView> getLinks();
	void setLinks(List<LinkView> links);

	@Nullable
	@UpdatableMapping(updatable = false)
	@Mapping("org.id")
	UUID getOrgId();
	void setOrgId(UUID orgId);
}
