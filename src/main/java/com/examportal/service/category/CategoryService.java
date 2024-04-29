package com.examportal.service.category;

import com.examportal.controller.category.request.CategoryCreateRequest;
import com.examportal.controller.category.request.CategoryUpdateRequest;
import com.examportal.controller.category.response.CategoryResponse;
import com.examportal.data.BaseResponse;
import com.examportal.data.entities.Category;
import com.examportal.data.enums.ResponseStatus;
import com.examportal.repository.category.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class CategoryService {

  private CategoryRepo categoryRepo;

  @Autowired
  CategoryService(CategoryRepo categoryRepo) {
    this.categoryRepo = categoryRepo;
  }

  public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {
    Category category = categoryCreateRequest.toCategory();
    Category savedCategory = categoryRepo.save(category);
    return new CategoryResponse(savedCategory);
  }

  public Category findById(Long id) {
    return categoryRepo.findById(id).orElse(null);
  }

  public CategoryResponse update(CategoryUpdateRequest categoryUpdateRequest) throws Exception {
    Optional<Category> opt = categoryRepo.findById(categoryUpdateRequest.getId());
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid category id");
    Category category = categoryUpdateRequest.toCategory(opt.get());
    Category saved = categoryRepo.save(category);
    return new CategoryResponse(saved);
  }

  public BaseResponse deleteById(Long id) throws Exception {
    Optional<Category> byId = categoryRepo.findById(id);
    if (byId.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid category id");
    categoryRepo.delete(byId.get());
    return new BaseResponse(ResponseStatus.OKAY);
  }
}
