package com.examportal.data.entities;

import com.examportal.data.BaseEntity;
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
public class Category extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "longtext")
  private String description;

  @JsonManagedReference(value = "category-quiz")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private List<Quiz> quizList;
}
