package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;

public class Item extends BaseItem {

  private String kana;
  private String onyomi;
  private String kunyomi;
  private String nanori;
  private String importantReading;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date unlockedDate;

  public Item() {
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
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

  public Date getUnlockedDate() {
    return unlockedDate;
  }

  public void setUnlockedDate(Date unlockedDate) {
    this.unlockedDate = unlockedDate;
  }

  @Override
  public String toString() {
    return "Item{" +
        ", kana='" + kana + '\'' +
        ", onyomi='" + onyomi + '\'' +
        ", kunyomi='" + kunyomi + '\'' +
        ", nanori='" + nanori + '\'' +
        ", importantReading='" + importantReading + '\'' +
        ", unlockedDate=" + unlockedDate +
        '}';
  }
}
