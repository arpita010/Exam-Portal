package com.examportal.controller.quiz.response;

import com.examportal.data.entities.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
  private Long id;
  private String title;
  private String description;
  private Long numberOfQuestions;
  private Long maxScore;
  private Boolean isPublished;

  public QuizResponse(Quiz quiz) {
    this.id = quiz.getId();
    this.title = quiz.getTitle();
    this.description = quiz.getDescription();
    this.numberOfQuestions = quiz.getNumberOfQuestions();
    this.maxScore = quiz.getMaxScore();
    this.isPublished = quiz.getIsPublished();
  }
}
