package com.wanikani.api.model;

public class LevelProgression {

  private int radicalsProgress;
  private int radicalsTotal;
  private int kanjiProgress;
  private int kanjiTotal;

  public LevelProgression() {
  }

  public int getRadicalsProgress() {
    return radicalsProgress;
  }

  public void setRadicalsProgress(int radicalsProgress) {
    this.radicalsProgress = radicalsProgress;
  }

  public int getRadicalsTotal() {
    return radicalsTotal;
  }

  public void setRadicalsTotal(int radicalsTotal) {
    this.radicalsTotal = radicalsTotal;
  }

  public int getKanjiProgress() {
    return kanjiProgress;
  }

  public void setKanjiProgress(int kanjiProgress) {
    this.kanjiProgress = kanjiProgress;
  }

  public int getKanjiTotal() {
    return kanjiTotal;
  }

  public void setKanjiTotal(int kanjiTotal) {
    this.kanjiTotal = kanjiTotal;
  }

  @Override
  public String toString() {
    return "LevelProgression{" +
        "radicalsProgress=" + radicalsProgress +
        ", radicalsTotal=" + radicalsTotal +
        ", kanjiProgress=" + kanjiProgress +
        ", kanjiTotal=" + kanjiTotal +
        '}';
  }
}
