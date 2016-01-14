package com.barban.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barban.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}