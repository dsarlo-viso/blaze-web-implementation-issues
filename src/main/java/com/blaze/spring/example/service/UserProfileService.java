package com.blaze.spring.example.service;

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

	public List<UserProfileView> getAllUserProfiles() {
		return userProfileRepository.getAllUserProfiles();
	}

	public UserProfileView saveUserProfile(UserProfileView userProfileView) {
		return userProfileRepository.saveUserProfile(userProfileView);
	}

	public Flux<UserProfileView> getUserProfilesFlux() {
		return Flux.using(userProfileRepository::getUserProfilesStream, Flux::fromStream, BaseStream::close);
	}
}
