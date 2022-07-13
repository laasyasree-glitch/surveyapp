package com.springbootproject.firstspringbootproject.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springbootproject.firstspringbootproject.DriverClasses.Survey;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface RestSurveyRepository extends
		PagingAndSortingRepository<Survey, Long> {
	List<Survey> findById(@Param("id") String role);
}
