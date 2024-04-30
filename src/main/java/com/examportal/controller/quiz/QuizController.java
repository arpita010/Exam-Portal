package com.examportal.controller.quiz;

import com.examportal.controller.quiz.request.QuizCreateRequest;
import com.examportal.controller.quiz.request.QuizUpdateRequest;
import com.examportal.controller.quiz.response.QuizResponse;
import com.examportal.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/quiz")
public class QuizController {

  private QuizService quizService;

  @Autowired
  QuizController(QuizService quizService) {
    this.quizService = quizService;
  }

  @PostMapping("/create")
  public QuizResponse create(QuizCreateRequest quizCreateRequest) {
    return quizService.create(quizCreateRequest);
  }

  @PostMapping("/update")
  public QuizResponse update(QuizUpdateRequest quizUpdateRequest) throws Exception {
    return quizService.update(quizUpdateRequest);
  }


}
