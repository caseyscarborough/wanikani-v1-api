package com.wanikani.api.model;

public class Level {

  private Integer radicals;
  private Integer kanji;
  private Integer vocabulary;
  private Integer total;

  public Level() {
  }

  public Integer getRadicals() {
    return radicals;
  }

  public void setRadicals(Integer radicals) {
    this.radicals = radicals;
  }

  public Integer getKanji() {
    return kanji;
  }

  public void setKanji(Integer kanji) {
    this.kanji = kanji;
  }

  public Integer getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(Integer vocabulary) {
    this.vocabulary = vocabulary;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "Level{" +
        "radicals=" + radicals +
        ", kanji=" + kanji +
        ", vocabulary=" + vocabulary +
        ", total=" + total +
        '}';
  }
}
