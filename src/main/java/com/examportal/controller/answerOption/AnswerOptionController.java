package com.examportal.controller.answerOption;

import com.examportal.controller.answerOption.request.AnswerOptionCreateRequest;
import com.examportal.controller.answerOption.request.AnswerOptionUpdateRequest;
import com.examportal.controller.answerOption.response.AnswerOptionResponse;
import com.examportal.data.BaseResponse;
import com.examportal.service.answerOption.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/answerOption")
public class AnswerOptionController {

  private AnswerOptionService answerOptionService;

  @Autowired
  AnswerOptionController(AnswerOptionService answerOptionService) {
    this.answerOptionService = answerOptionService;
  }

  @PostMapping("/create")
  public AnswerOptionResponse create(
      @RequestBody AnswerOptionCreateRequest answerOptionCreateRequest) throws Exception {
    return answerOptionService.create(answerOptionCreateRequest);
  }

  @PostMapping("/update")
  public AnswerOptionResponse update(
      @RequestBody AnswerOptionUpdateRequest answerOptionUpdateRequest) throws Exception {
    return answerOptionService.update(answerOptionUpdateRequest);
  }

  @DeleteMapping("/delete/{id}")
  public BaseResponse delete(@PathVariable(value = "id") Long id) throws Exception {
    return answerOptionService.delete(id);
  }
}
