package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vocabulary extends BaseItem {

  private String kana;

  @JsonProperty("user_specific")
  private Statistics statistics;

  public Vocabulary() {
    this.type = ItemType.VOCABULARY;
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

  @Override
  public String toString() {
    return "Vocabulary{" +
        "kana='" + kana + '\'' +
        ", statistics=" + statistics +
        "} " + super.toString();
  }
}
