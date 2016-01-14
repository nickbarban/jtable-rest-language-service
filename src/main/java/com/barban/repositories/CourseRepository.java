package com.barban.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barban.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}