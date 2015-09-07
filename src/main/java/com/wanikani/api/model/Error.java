package com.wanikani.api.model;

public class Error {

  private String code;
  private String message;

  public Error() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Error{" +
        "code='" + code + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
