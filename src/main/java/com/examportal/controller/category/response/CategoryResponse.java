package com.examportal.controller.category.response;

import com.examportal.data.BaseResponse;
import com.examportal.data.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends BaseResponse {
  private Long categoryId;
  private String title;
  private String description;

  public CategoryResponse(Category category) {
    this.categoryId = category.getId();
    this.title = category.getTitle();
    this.description = category.getDescription();
  }
}
