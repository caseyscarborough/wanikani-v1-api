package com.wanikani.api.model;

public class GeneralWrapper<T> {

  private T general;

  public GeneralWrapper() {
  }

  public T getGeneral() {
    return general;
  }

  public void setGeneral(T general) {
    this.general = general;
  }

  @Override
  public String toString() {
    return "GeneralWrapper{" +
        "general=" + general +
        '}';
  }
}
