package com.barban.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barban.model.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
}