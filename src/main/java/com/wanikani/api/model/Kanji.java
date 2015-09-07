package com.wanikani.api.model;

public class Kanji {

  private String character;
  private String meaning;
  private String onyomi;
  private String kunyomi;
  private String nanori;
  private String importantReading;
  private Integer level;
  private Statistics statistics;

  public Kanji() {
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
    return "Kanji{" +
        "character='" + character + '\'' +
        ", meaning='" + meaning + '\'' +
        ", onyomi='" + onyomi + '\'' +
        ", kunyomi='" + kunyomi + '\'' +
        ", nanori='" + nanori + '\'' +
        ", importantReading='" + importantReading + '\'' +
        ", level=" + level +
        ", statistics=" + statistics +
        '}';
  }
}
