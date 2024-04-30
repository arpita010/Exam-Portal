package com.examportal.data.enums;

public enum Difficulty {
  BASIC("BASIC"),
  LOW("LOW"),
  MEDIUM("MEDIUM"),
  HIGH("HIGH");

  private String difficulty;

  Difficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String toString() {
    return this.difficulty;
  }
}
