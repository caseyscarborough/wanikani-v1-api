package com.wanikani.api.model;

public class Response<T> {

  private UserInformation userInformation;
  private T requestedInformation;
  private Error error;

  public Response() {
  }

  public UserInformation getUserInformation() {
    return userInformation;
  }

  public T getRequestedInformation() {
    return requestedInformation;
  }

  public Error getError() {
    return error;
  }

  @Override
  public String toString() {
    return "Response{" +
        "userInformation=" + userInformation +
        ", requestedInformation=" + requestedInformation +
        ", error=" + error +
        '}';
  }
}
