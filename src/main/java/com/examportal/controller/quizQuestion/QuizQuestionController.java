package com.examportal.controller.quizQuestion;

import com.examportal.controller.quizQuestion.request.QuizQuestionCreateRequest;
import com.examportal.controller.quizQuestion.request.QuizQuestionUpdateRequest;
import com.examportal.controller.quizQuestion.response.QuizQuestionResponse;
import com.examportal.data.BaseResponse;
import com.examportal.service.quizQuestion.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quizQuestion")
public class QuizQuestionController {

  private QuizQuestionService quizQuestionService;

  @Autowired
  QuizQuestionController(QuizQuestionService quizQuestionService) {
    this.quizQuestionService = quizQuestionService;
  }

  @PostMapping("/create")
  public QuizQuestionResponse create(
      @RequestBody QuizQuestionCreateRequest quizQuestionCreateRequest) throws Exception {
    return quizQuestionService.create(quizQuestionCreateRequest);
  }

  @PostMapping("/update")
  public QuizQuestionResponse update(
      @RequestBody QuizQuestionUpdateRequest quizQuestionUpdateRequest) throws Exception {
    return quizQuestionService.update(quizQuestionUpdateRequest);
  }

  @DeleteMapping("/delete/{id}")
  public BaseResponse delete(@PathVariable(value = "id") Long id) throws Exception {
    return quizQuestionService.deleteById(id);
  }
}
