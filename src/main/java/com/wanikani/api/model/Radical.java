package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Radical extends StatisticsItem {

  private String image;

  public Radical() {
    this.type = ItemType.RADICAL;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "Radical{" +
        "image='" + image + '\'' +
        "} " + super.toString();
  }
}
