package com.examportal.repository.answerOption;

import com.examportal.data.entities.AnswerOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionRepo extends CrudRepository<AnswerOption, Long> {}
