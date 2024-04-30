package com.examportal.controller.quiz.request;

import com.examportal.data.entities.Quiz;
import com.examportal.data.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizUpdateRequest {
  private Long id;
  private String title;
  private String description;
  private Long numberOfQuestions;
  private Boolean isPublished;

  private Difficulty difficulty;

  public Quiz toQuiz(Quiz quiz) {
    if (null != this.title) quiz.setTitle(this.title);
    if (null != this.description) quiz.setDescription(this.description);
    if (null != this.numberOfQuestions) quiz.setNumberOfQuestions(this.numberOfQuestions);
    if (null != this.isPublished) quiz.setIsPublished(this.isPublished);
    if (null != this.difficulty) quiz.setDifficulty(this.difficulty);
    return quiz;
  }
}
