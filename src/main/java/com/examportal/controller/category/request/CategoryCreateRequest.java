package com.examportal.controller.category.request;

import com.examportal.data.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequest {
  private String title;
  private String description;

  public Category toCategory() {
    Category category = new Category();
    category.setTitle(this.title);
    category.setDescription(this.description);
    return category;
  }
}
