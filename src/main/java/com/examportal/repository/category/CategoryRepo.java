package com.examportal.repository.category;

import com.examportal.data.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {


}
