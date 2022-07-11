package com.springbootproject.firstspringbootproject.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootproject.firstspringbootproject.Question;

public interface QuestionsRepository extends JpaRepository<Question,Long>{

}