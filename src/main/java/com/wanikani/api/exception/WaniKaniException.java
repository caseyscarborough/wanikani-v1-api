package com.wanikani.api.exception;

public class WaniKaniException extends RuntimeException {

  private String errorCode;

  public WaniKaniException(String message) {
    super(message);
  }

  public WaniKaniException(String message, Throwable cause) {
    super(message, cause);
  }

  public WaniKaniException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
