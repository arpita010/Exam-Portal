package com.examportal.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnswerOption {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String value;

  private Boolean isTrue;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonBackReference("question-answer")
  @JoinColumn(nullable = false)
  private QuizQuestion quizQuestion;
}
