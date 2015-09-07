package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanikani.api.config.Configuration;

public class Vocabulary extends BaseItem {

  private String kana;

  @JsonProperty("user_specific")
  private Statistics statistics;

  public Vocabulary() {
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
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
    return Configuration.VOCABULARY_BASE_URL + character;
  }

  @Override
  public String toString() {
    return "Vocabulary{" +
        "kana='" + kana + '\'' +
        ", statistics=" + statistics +
        "} " + super.toString();
  }
}
