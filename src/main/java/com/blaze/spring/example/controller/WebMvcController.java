package com.blaze.spring.example.controller;

import com.blaze.spring.example.domain.Org;
import com.blaze.spring.example.repository.OrgRepository;
import com.blaze.spring.example.service.UserProfileService;
import com.blaze.spring.example.service.views.UserProfileView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/web-mvc")
@RestController
public class WebMvcController {

	private final UserProfileService userProfileService;
	private final OrgRepository orgRepository;

	public WebMvcController(UserProfileService userProfileService, OrgRepository orgRepository) {
		this.userProfileService = userProfileService;
		this.orgRepository = orgRepository;
	}

	@GetMapping
	public ResponseEntity<List<UserProfileView>> getAllUserProfiles() {
		return ResponseEntity.ok(userProfileService.getAllUserProfileViews());
	}

	@PostMapping
	public ResponseEntity<UserProfileView> createUserProfile(@RequestBody UserProfileView userProfileView) {
		return ResponseEntity.ok(userProfileService.saveUserProfileView(userProfileView));
	}

	@PostMapping("/org")
	public ResponseEntity<Org> createTestOrg() {
		Org newOrg = new Org();
		newOrg.setName("Test Org");
		return ResponseEntity.ok(orgRepository.save(newOrg));
	}
}
