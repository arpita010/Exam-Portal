package com.examportal.service.answerOption;

import com.examportal.controller.answerOption.request.AnswerOptionCreateRequest;
import com.examportal.controller.answerOption.request.AnswerOptionUpdateRequest;
import com.examportal.controller.answerOption.response.AnswerOptionResponse;
import com.examportal.data.BaseResponse;
import com.examportal.data.entities.AnswerOption;
import com.examportal.data.entities.QuizQuestion;
import com.examportal.data.enums.ResponseStatus;
import com.examportal.repository.answerOption.AnswerOptionRepo;
import com.examportal.service.quizQuestion.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class AnswerOptionService {
  private QuizQuestionService quizQuestionService;
  private AnswerOptionRepo answerOptionRepo;

  @Autowired
  AnswerOptionService(QuizQuestionService quizQuestionService, AnswerOptionRepo answerOptionRepo) {
    this.quizQuestionService = quizQuestionService;
    this.answerOptionRepo = answerOptionRepo;
  }

  public AnswerOptionResponse create(AnswerOptionCreateRequest answerOptionCreateRequest) {
    QuizQuestion quizQuestion =
        quizQuestionService.findById(answerOptionCreateRequest.getQuestionId());
    if (quizQuestion == null)
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Question not found");
    AnswerOption answerOption = answerOptionCreateRequest.toAnswerOption(quizQuestion);
    AnswerOption saved = answerOptionRepo.save(answerOption);
    return new AnswerOptionResponse(saved);
  }

  public AnswerOptionResponse update(AnswerOptionUpdateRequest answerOptionUpdateRequest)
      throws Exception {
    Optional<AnswerOption> opt = findById(answerOptionUpdateRequest.getId());
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid answer option ID");

    AnswerOption answerOption = answerOptionUpdateRequest.toAnswerOption(opt.get());
    AnswerOption updated = answerOptionRepo.save(answerOption);
    return new AnswerOptionResponse(updated);
  }

  public Optional<AnswerOption> findById(Long id) {
    return answerOptionRepo.findById(id);
  }

  public BaseResponse delete(Long id) throws Exception {
    Optional<AnswerOption> opt = findById(id);
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid answer option id");
    answerOptionRepo.delete(opt.get());
    return new BaseResponse(ResponseStatus.OKAY);
  }
}
