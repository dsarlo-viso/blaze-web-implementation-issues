package com.blaze.spring.example.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "user_profiles")
public class UserProfile {
	@Id
	@Column(name = "id")
	private UUID id = UUID.randomUUID();

	@ElementCollection
	@CollectionTable(name = "profile_links", joinColumns = @JoinColumn(name = "profile_id"))
	@OrderColumn(name = "index", nullable = false)
	private List<Link> links = new ArrayList<>();

	private String firstName;

	private String lastName;

	@Nullable
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id", updatable = false)
	private Org org;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Nullable
	public Org getOrg() {
		return org;
	}

	public void setOrg(@Nullable Org org) {
		this.org = org;
	}
}
