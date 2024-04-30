package com.examportal.controller.quizQuestion.request;

import com.examportal.data.entities.Quiz;
import com.examportal.data.entities.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionCreateRequest {
  private String question;
  private Long quizId;

  public QuizQuestion toQuizQuestion(Quiz quiz) {
    QuizQuestion quizQuestion = new QuizQuestion();
    quizQuestion.setQuestion(this.question);
    quizQuestion.setQuiz(quiz);
    return quizQuestion;
  }
}
