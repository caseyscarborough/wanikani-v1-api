package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelProgression {

  @JsonProperty("radicals_progress")
  private Integer radicalsProgress;

  @JsonProperty("radicals_total")
  private Integer radicalsTotal;

  @JsonProperty("kanji_progress")
  private Integer kanjiProgress;

  @JsonProperty("kanji_total")
  private Integer kanjiTotal;

  public LevelProgression() {
  }

  public Integer getRadicalsProgress() {
    return radicalsProgress;
  }

  public void setRadicalsProgress(Integer radicalsProgress) {
    this.radicalsProgress = radicalsProgress;
  }

  public Integer getRadicalsTotal() {
    return radicalsTotal;
  }

  public void setRadicalsTotal(Integer radicalsTotal) {
    this.radicalsTotal = radicalsTotal;
  }

  public Integer getKanjiProgress() {
    return kanjiProgress;
  }

  public void setKanjiProgress(Integer kanjiProgress) {
    this.kanjiProgress = kanjiProgress;
  }

  public Integer getKanjiTotal() {
    return kanjiTotal;
  }

  public void setKanjiTotal(Integer kanjiTotal) {
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
