package com.wanikani.api.model;

public class CriticalItem extends Item {

  private String percentage;

  public CriticalItem() {
  }

  public String getPercentage() {
    return percentage;
  }

  public void setPercentage(String percentage) {
    this.percentage = percentage;
  }

  @Override
  public String toString() {
    return "CriticalItem{" +
        "item=" + super.toString() +
        ",percentage='" + percentage + '\'' +
        '}';
  }
}
