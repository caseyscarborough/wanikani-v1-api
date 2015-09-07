package com.wanikani.api.model;

public class Response<T> {

  private UserInformation userInformation;
  private T requestedInformation;

  public Response() {
  }

  public UserInformation getUserInformation() {
    return userInformation;
  }

  public T getRequestedInformation() {
    return requestedInformation;
  }

  @Override
  public String toString() {
    return "Response{" +
        "userInformation=" + userInformation +
        ", requestedInformation=" + requestedInformation +
        '}';
  }
}
