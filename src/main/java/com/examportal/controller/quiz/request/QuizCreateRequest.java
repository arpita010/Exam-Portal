package com.examportal.controller.quiz.request;

import com.examportal.data.entities.Quiz;
import com.examportal.data.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizCreateRequest {
  private String title;
  private String description;
  private Long numberOfQuestions;
  private Long maxScore;
  private Boolean isPublished;
  private Difficulty difficulty;

  public Quiz toQuiz() {
    Quiz quiz = new Quiz();
    quiz.setTitle(this.title);
    quiz.setDescription(this.description);
    quiz.setNumberOfQuestions(this.numberOfQuestions);
    quiz.setMaxScore(this.maxScore);
    quiz.setIsPublished(this.isPublished);
    quiz.setDifficulty(this.difficulty);
    return quiz;
  }
}
