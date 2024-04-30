package com.examportal.controller.quizQuestion.response;

import com.examportal.data.BaseResponse;
import com.examportal.data.entities.Quiz;
import com.examportal.data.entities.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionResponse extends BaseResponse {
  private Long quizId;
  private String question;

  public QuizQuestionResponse(QuizQuestion quizQuestion) {
    this.quizId = quizQuestion.getQuiz().getId();
    this.question = quizQuestion.getQuestion();
  }
}
