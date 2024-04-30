package com.examportal.controller.answerOption.request;

import com.examportal.data.entities.AnswerOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionUpdateRequest {
  private Long id;
  private String value;
  private Boolean isTrue;

  public AnswerOption toAnswerOption(AnswerOption answerOption) {
    if (this.value != null) answerOption.setValue(this.value);
    if (this.isTrue != null) answerOption.setIsTrue(this.isTrue);
    return answerOption;
  }
}
