package com.springbootproject.firstspringbootproject.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface RestUserRepository extends
		PagingAndSortingRepository<User, Long> {
	List<User> findByRole(@Param("role") String role);
}