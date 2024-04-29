package com.examportal.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuizQuestion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String question;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonBackReference(value = "quiz-question")
  @JoinColumn(nullable = false)
  private Quiz quiz;

  @JsonManagedReference("question-answer")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizQuestion")
  private List<AnswerOption> answerOptions;
}
