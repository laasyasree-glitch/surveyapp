package com.springbootproject.firstspringbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.firstspringbootproject.DriverClasses.Question;

public interface QuestionsRepository extends JpaRepository<Question,Long>{

}