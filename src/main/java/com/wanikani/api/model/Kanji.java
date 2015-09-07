package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kanji extends BaseItem {

  private String onyomi;
  private String kunyomi;
  private String nanori;
  private String importantReading;

  @JsonProperty("user_specific")
  private Statistics statistics;

  public Kanji() {
    this.type = ItemType.KANJI;
  }

  public String getOnyomi() {
    return onyomi;
  }

  public void setOnyomi(String onyomi) {
    this.onyomi = onyomi;
  }

  public String getKunyomi() {
    return kunyomi;
  }

  public void setKunyomi(String kunyomi) {
    this.kunyomi = kunyomi;
  }

  public String getNanori() {
    return nanori;
  }

  public void setNanori(String nanori) {
    this.nanori = nanori;
  }

  public String getImportantReading() {
    return importantReading;
  }

  public void setImportantReading(String importantReading) {
    this.importantReading = importantReading;
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

  @Override
  public String toString() {
    return "Kanji{" +
        "onyomi='" + onyomi + '\'' +
        ", kunyomi='" + kunyomi + '\'' +
        ", nanori='" + nanori + '\'' +
        ", importantReading='" + importantReading + '\'' +
        ", statistics=" + statistics +
        "} " + super.toString();
  }
}
