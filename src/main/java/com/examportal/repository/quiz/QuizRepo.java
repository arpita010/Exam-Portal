package com.examportal.repository.quiz;

import com.examportal.data.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo
    extends PagingAndSortingRepository<Quiz, Long>, CrudRepository<Quiz, Long> {

}
