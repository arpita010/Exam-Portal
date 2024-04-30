package com.examportal.service.quizQuestion;

import com.examportal.controller.quizQuestion.request.QuizQuestionCreateRequest;
import com.examportal.controller.quizQuestion.request.QuizQuestionUpdateRequest;
import com.examportal.controller.quizQuestion.response.QuizQuestionResponse;
import com.examportal.data.BaseResponse;
import com.examportal.data.entities.Quiz;
import com.examportal.data.entities.QuizQuestion;
import com.examportal.data.enums.ResponseStatus;
import com.examportal.repository.quizQuestion.QuizQuestionRepo;
import com.examportal.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class QuizQuestionService {
  private QuizQuestionRepo quizQuestionRepo;

  private QuizService quizService;

  @Autowired
  QuizQuestionService(QuizQuestionRepo quizQuestionRepo, QuizService quizService) {
    this.quizQuestionRepo = quizQuestionRepo;
    this.quizService = quizService;
  }

  public QuizQuestionResponse create(QuizQuestionCreateRequest quizQuestionCreateRequest)
      throws Exception {
    Quiz quiz = quizService.findById(quizQuestionCreateRequest.getQuizId());
    if (null == quiz)
      throw new HttpClientErrorException(
          HttpStatus.BAD_REQUEST, "quiz is not found for adding question");

    QuizQuestion quizQuestion = quizQuestionCreateRequest.toQuizQuestion(quiz);
    QuizQuestion saved = quizQuestionRepo.save(quizQuestion);
    return new QuizQuestionResponse(saved);
  }

  public QuizQuestionResponse update(QuizQuestionUpdateRequest quizQuestionUpdateRequest)
      throws Exception {
    Optional<QuizQuestion> opt =
        quizQuestionRepo.findById(quizQuestionUpdateRequest.getQuestionId());
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid question id");

    QuizQuestion quizQuestion = quizQuestionUpdateRequest.toQuizQuestion(opt.get());
    QuizQuestion updated = quizQuestionRepo.save(quizQuestion);
    return new QuizQuestionResponse(updated);
  }

  public BaseResponse deleteById(Long questionId) {
    Optional<QuizQuestion> opt = quizQuestionRepo.findById(questionId);
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid question id");
    quizQuestionRepo.delete(opt.get());
    return new BaseResponse(ResponseStatus.OKAY);
  }
}
