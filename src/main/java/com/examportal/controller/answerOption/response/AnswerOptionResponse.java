package com.examportal.controller.answerOption.response;

import com.examportal.data.BaseResponse;
import com.examportal.data.entities.AnswerOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionResponse extends BaseResponse {
  private String value;
  private Long questionId;
  private Boolean isTrue;

  public AnswerOptionResponse(AnswerOption answerOption) {
    this.value = answerOption.getValue();
    this.questionId = answerOption.getQuizQuestion().getId();
    this.isTrue = answerOption.getIsTrue();
  }
}
