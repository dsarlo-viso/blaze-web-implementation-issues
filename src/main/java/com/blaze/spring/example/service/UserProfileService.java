package com.blaze.spring.example.service;

import com.blaze.spring.example.domain.UserProfile;
import com.blaze.spring.example.repository.UserProfileRepository;
import com.blaze.spring.example.service.views.UserProfileView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.BaseStream;

@Transactional
@Service
public class UserProfileService {

	private final UserProfileRepository userProfileRepository;

	public UserProfileService(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	public List<UserProfile> getAllUserProfiles() {
		return userProfileRepository.getAllUserProfiles();
	}

	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.saveUserProfile(userProfile);
	}

	public List<UserProfileView> getAllUserProfileViews() {
		return userProfileRepository.getAllUserProfileViews();
	}

	public UserProfileView saveUserProfileView(UserProfileView userProfileView) {
		return userProfileRepository.saveUserProfileView(userProfileView);
	}

	public Flux<UserProfileView> getUserProfilesFlux() {
		return Flux.using(userProfileRepository::getUserProfilesStream, Flux::fromStream, BaseStream::close);
	}
}
