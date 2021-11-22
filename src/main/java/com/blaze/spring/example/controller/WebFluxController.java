package com.blaze.spring.example.controller;

import com.blaze.spring.example.service.UserProfileService;
import com.blaze.spring.example.service.views.UserProfileView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping ("/api/web-flux")
@RestController
public class WebFluxController {

	private final UserProfileService userProfileService;

	public WebFluxController(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@GetMapping
	public Flux<UserProfileView> getAllUserProfiles() {
		return userProfileService.getUserProfilesFlux();
	}
}
