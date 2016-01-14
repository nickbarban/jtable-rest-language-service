package com.barban.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barban.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {
}