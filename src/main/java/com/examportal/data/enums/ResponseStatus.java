package com.examportal.data.enums;

public enum ResponseStatus {
  OKAY("OKAY"),
  FAILED("FAILED");
  private String responseStatus;

  ResponseStatus(String responseStatus) {
    this.responseStatus = responseStatus;
  }

  @Override
  public String toString() {
    return this.responseStatus;
  }
}
