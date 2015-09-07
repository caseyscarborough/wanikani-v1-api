package com.wanikani.api.model;

public class Vocabulary {

  private String character;
  private String kana;
  private String meaning;
  private Integer level;

  public Vocabulary() {
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return "Vocabulary{" +
        "character='" + character + '\'' +
        ", kana='" + kana + '\'' +
        ", meaning='" + meaning + '\'' +
        ", level=" + level +
        '}';
  }
}
