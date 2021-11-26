package com.blaze.spring.example.repository;

import com.blaze.spring.example.domain.UserProfile;
import com.blaze.spring.example.service.views.UserProfileView;
import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserProfileRepository {

	private final EntityViewManager evm;
	private final EntityManager em;
	private final CriteriaBuilderFactory cbf;

	public UserProfileRepository(
			EntityViewManager evm, EntityManager em, CriteriaBuilderFactory cbf
	) {
		this.evm = evm;
		this.em = em;
		this.cbf = cbf;
	}

	public List<UserProfileView> getAllUserProfiles() {
		CriteriaBuilder<UserProfile> criteriaBuilder = cbf.create(em, UserProfile.class);
		CriteriaBuilder<UserProfileView> userProfileBuilder = evm.applySetting(EntityViewSetting.create(
				UserProfileView.class), criteriaBuilder);
		return userProfileBuilder.getQuery().getResultList();
	}

	public UserProfileView saveUserProfile(UserProfileView userProfileView) {
		evm.save(em, userProfileView);
		return userProfileView;
	}

	public Stream<UserProfileView> getUserProfilesStream() {
		CriteriaBuilder<UserProfile> criteriaBuilder = cbf.create(em, UserProfile.class);
		CriteriaBuilder<UserProfileView> userProfileBuilder = evm.applySetting(EntityViewSetting.create(UserProfileView.class), criteriaBuilder);
		TypedQuery<UserProfileView> query = userProfileBuilder.getQuery();

		return query.getResultStream();
	}
}
