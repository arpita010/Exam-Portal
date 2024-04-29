package com.examportal.data;

import com.examportal.data.enums.ResponseStatus;

public class BaseResponse {
  private ResponseStatus responseStatus;

  public BaseResponse(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
  }

  public BaseResponse() {
    this.responseStatus = ResponseStatus.OKAY;
  }
}
