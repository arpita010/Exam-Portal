package com.examportal.repository.quizQuestion;

import com.examportal.data.entities.QuizQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepo extends PagingAndSortingRepository<QuizQuestion,Long>, CrudRepository<QuizQuestion,Long> {

}
