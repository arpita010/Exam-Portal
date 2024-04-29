package com.examportal.controller.category.request;

import com.examportal.data.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {
  private Long id;
  private String title;
  private String description;

  public Category toCategory(Category category) {
    if (null != title) category.setTitle(this.title);
    if (null != description) category.setDescription(this.description);
    return category;
  }
}
