package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Radical {

  private String character;
  private String meaning;
  private String image;
  private Integer level;

  @JsonProperty("user_specific")
  private Statistics statistics;

  public Radical() {
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Statistics getStatistics() {
    return statistics;
  }

  public void setStatistics(Statistics statistics) {
    this.statistics = statistics;
  }

  @Override
  public String toString() {
    return "Radical{" +
        "character='" + character + '\'' +
        ", meaning='" + meaning + '\'' +
        ", image='" + image + '\'' +
        ", level=" + level +
        ", statistics=" + statistics +
        '}';
  }
}
