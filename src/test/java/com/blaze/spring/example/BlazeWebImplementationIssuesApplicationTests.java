package com.blaze.spring.example;

import com.blaze.spring.example.service.UserProfileService;
import com.blaze.spring.example.service.views.LinkView;
import com.blaze.spring.example.service.views.LinkViewImpl;
import com.blaze.spring.example.service.views.UserProfileView;
import com.blaze.spring.example.service.views.UserProfileViewImpl;
import com.blazebit.persistence.view.EntityViewManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlazeWebImplementationIssuesApplicationTests {
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	EntityViewManager evm;

	@Test
	void contextLoads() {
	}

	@Test
	void addingLinkViews_whenSaved_createsLinks() {
		List<UserProfileView> allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(0, allUserProfiles.size());


		UserProfileView userProfileView = evm.create(UserProfileView.class);
		userProfileView.setFirstName("Jason");
		userProfileView.setLastName("Carreira");

		LinkView link1 = evm.create(LinkView.class);
		link1.setName("Google");
		link1.setUrl("https://www.google.com");

		userProfileView = userProfileService.saveUserProfile(userProfileView);
		allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(1, allUserProfiles.size());
		Assertions.assertEquals(1, allUserProfiles.get(0).getLinks().size());

		LinkView link2 = evm.create(LinkView.class);
		link2.setName("Yahoo");
		link2.setUrl("https://www.yahoo.com");

		userProfileView.getLinks().add(link2);
		userProfileView = userProfileService.saveUserProfile(userProfileView);
		allUserProfiles = userProfileService.getAllUserProfiles();
		Assertions.assertEquals(1, allUserProfiles.size());
		Assertions.assertEquals(2, allUserProfiles.get(0).getLinks().size());
	}
}
