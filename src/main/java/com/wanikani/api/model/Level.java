package com.wanikani.api.model;

public class Level {

  private int radicals;
  private int kanji;
  private int vocabulary;
  private int total;

  public Level() {
  }

  public int getRadicals() {
    return radicals;
  }

  public void setRadicals(int radicals) {
    this.radicals = radicals;
  }

  public int getKanji() {
    return kanji;
  }

  public void setKanji(int kanji) {
    this.kanji = kanji;
  }

  public int getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(int vocabulary) {
    this.vocabulary = vocabulary;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
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
