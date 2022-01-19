package com.blaze.spring.example.repository;

import com.blaze.spring.example.domain.Org;
import com.blaze.spring.example.domain.UserProfile;
import com.blaze.spring.example.service.views.UserProfileView;
import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface OrgRepository extends JpaRepository<Org, UUID> {

}
