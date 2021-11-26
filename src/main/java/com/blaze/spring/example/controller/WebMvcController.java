package com.blaze.spring.example.controller;

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

	public WebMvcController(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@GetMapping
	public ResponseEntity<List<UserProfileView>> getAllUserProfiles() {
		return ResponseEntity.ok(userProfileService.getAllUserProfiles());
	}

	@PostMapping
	public ResponseEntity<UserProfileView> createUserProfile(@RequestBody UserProfileView userProfileView) {
		return ResponseEntity.ok(userProfileService.saveUserProfile(userProfileView));
	}
}
