package com.examportal.controller.quizQuestion.request;

import com.examportal.data.entities.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionUpdateRequest {
  private Long questionId;
  private String question;

  public QuizQuestion toQuizQuestion(QuizQuestion quizQuestion) {
    if (null != this.question) quizQuestion.setQuestion(this.question);
    return quizQuestion;
  }
}
