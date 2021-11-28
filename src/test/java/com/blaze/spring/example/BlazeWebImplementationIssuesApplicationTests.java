package com.blaze.spring.example;

import com.blaze.spring.example.domain.Link;
import com.blaze.spring.example.domain.UserProfile;
import com.blaze.spring.example.service.UserProfileService;
import com.blaze.spring.example.service.views.LinkView;
import com.blaze.spring.example.service.views.UserProfileView;
import com.blazebit.persistence.view.EntityViewManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
class BlazeWebImplementationIssuesApplicationTests {
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	EntityViewManager evm;

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void addingLinks_whenSaved_createsLinks() {
		List<UserProfile> allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(0, allUserProfiles.size());

		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName("Jason");
		userProfile.setLastName("Carreira");

		Link link1 = new Link();
		link1.setName("Google");
		link1.setUrl("https://www.google.com");
		userProfile.getLinks().add(link1);

		userProfile = userProfileService.saveUserProfile(userProfile);
		allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(1, allUserProfiles.size());
		Assertions.assertEquals(1, allUserProfiles.get(0).getLinks().size());

		Link link2 = new Link();
		link2.setName("Yahoo");
		link2.setUrl("https://www.yahoo.com");

		userProfile.getLinks().clear();
		userProfile.getLinks().add(link2);
		userProfile.getLinks().add(link1);
		userProfile = userProfileService.saveUserProfile(userProfile);
		allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(1, allUserProfiles.size());
		List<Link> links = allUserProfiles.get(0).getLinks();
		Assertions.assertEquals(2, links.size());
		Assertions.assertEquals(link2.getName(), links.get(0).getName());
		Assertions.assertEquals(link1.getName(), links.get(1).getName());
	}

	@Test
	void addingLinkViews_whenSaved_createsLinks() {
		List<UserProfileView> allUserProfiles = userProfileService.getAllUserProfileViews();
		Assertions.assertEquals(0, allUserProfiles.size());

		UserProfileView userProfileView = evm.create(UserProfileView.class);
		userProfileView.setFirstName("Jason");
		userProfileView.setLastName("Carreira");

		LinkView link1 = evm.create(LinkView.class);
		link1.setName("Google");
		link1.setUrl("https://www.google.com");
		userProfileView.getLinks().add(link1);

		userProfileView = userProfileService.saveUserProfileView(userProfileView);
		allUserProfiles = userProfileService.getAllUserProfileViews();
		Assertions.assertEquals(1, allUserProfiles.size());
		Assertions.assertEquals(1, allUserProfiles.get(0).getLinks().size());

		LinkView link2 = evm.create(LinkView.class);
		link2.setName("Yahoo");
		link2.setUrl("https://www.yahoo.com");

		userProfileView.getLinks().clear();
		userProfileView.getLinks().add(link2);
		userProfileView.getLinks().add(link1);
		userProfileView = userProfileService.saveUserProfileView(userProfileView);
		allUserProfiles = userProfileService.getAllUserProfileViews();
		Assertions.assertEquals(1, allUserProfiles.size());
		List<LinkView> links = allUserProfiles.get(0).getLinks();
		Assertions.assertEquals(2, links.size());
		Assertions.assertEquals(link2.getName(), links.get(0).getName());
		Assertions.assertEquals(link1.getName(), links.get(1).getName());
	}
}
