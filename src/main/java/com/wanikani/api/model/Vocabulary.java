package com.wanikani.api.model;

public class Vocabulary extends StatisticsItem {

  private String kana;

  public Vocabulary() {
    this.type = ItemType.VOCABULARY;
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
  }

  @Override
  public String toString() {
    return "Vocabulary{" +
        "kana='" + kana + '\'' +
        "} " + super.toString();
  }
}
