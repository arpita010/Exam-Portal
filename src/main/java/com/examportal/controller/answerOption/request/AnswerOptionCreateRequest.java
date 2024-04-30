package com.examportal.controller.answerOption.request;

import com.examportal.data.entities.AnswerOption;
import com.examportal.data.entities.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionCreateRequest {
  private Long questionId;
  private String value;
  private Boolean isTrue;

  public AnswerOption toAnswerOption(QuizQuestion quizQuestion) {
    AnswerOption answerOption = new AnswerOption();
    answerOption.setValue(this.value);
    answerOption.setIsTrue(this.isTrue);
    answerOption.setQuizQuestion(quizQuestion);
    return answerOption;
  }
}
