package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanikani.api.config.Configuration;

public class Radical extends BaseItem {

  private String image;

  @JsonProperty("user_specific")
  private Statistics statistics;

  public Radical() {
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Statistics getStatistics() {
    return statistics;
  }

  public void setStatistics(Statistics statistics) {
    this.statistics = statistics;
  }


  public boolean isUnlocked() {
    return statistics != null;
  }

  public String getInformationUrl() {
    return Configuration.RADICAL_BASE_URL + character;
  }

  @Override
  public String toString() {
    return "Radical{" +
        "image='" + image + '\'' +
        ", statistics=" + statistics +
        "} " + super.toString();
  }
}
