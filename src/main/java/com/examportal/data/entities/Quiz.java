package com.examportal.data.entities;

import com.examportal.data.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "longtext")
  private String description;

  private Long numberOfQuestions;

  private Long maxScore;

  private Boolean isPublished;

  @JsonBackReference(value = "category-quiz")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Category category;

  @JsonManagedReference(value = "quiz-question")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
  List<QuizQuestion> questions;
}
