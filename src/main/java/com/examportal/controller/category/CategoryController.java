package com.examportal.controller.category;

import com.examportal.controller.category.request.CategoryCreateRequest;
import com.examportal.controller.category.request.CategoryUpdateRequest;
import com.examportal.controller.category.response.CategoryResponse;
import com.examportal.data.BaseResponse;
import com.examportal.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping("/create")
  public CategoryResponse create(@RequestBody CategoryCreateRequest categoryCreateRequest) {
    return categoryService.create(categoryCreateRequest);
  }

  @PostMapping("/update")
  public CategoryResponse update(@RequestBody CategoryUpdateRequest categoryUpdateRequest)
      throws Exception {
    return categoryService.update(categoryUpdateRequest);
  }

  @DeleteMapping("/delete/{id}")
  public BaseResponse delete(@PathVariable(value = "id") Long id) throws Exception {
    return categoryService.deleteById(id);
  }
}
