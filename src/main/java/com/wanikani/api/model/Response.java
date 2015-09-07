package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

  @JsonProperty("user_information")
  private UserInformation userInformation;

  @JsonProperty("requested_information")
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
