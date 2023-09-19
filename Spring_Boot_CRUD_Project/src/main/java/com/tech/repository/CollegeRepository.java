package com.tech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.College;

@Repository
public interface CollegeRepository extends CrudRepository<College, String> {

}
