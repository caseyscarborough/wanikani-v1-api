package com.wanikani.api.model;

public class Item extends BaseItem {

  private String type;
  private String kana;
  private String onyomi;
  private String kunyomi;
  private String nanori;
  private String importantReading;
  private Long unlockedDate;

  public Item() {
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public Long getUnlockedDate() {
    return unlockedDate;
  }

  public void setUnlockedDate(Long unlockedDate) {
    this.unlockedDate = unlockedDate;
  }

  @Override
  public String toString() {
    return "Item{" +
        "type='" + type + '\'' +
        ", kana='" + kana + '\'' +
        ", onyomi='" + onyomi + '\'' +
        ", kunyomi='" + kunyomi + '\'' +
        ", nanori='" + nanori + '\'' +
        ", importantReading='" + importantReading + '\'' +
        ", unlockedDate=" + unlockedDate +
        '}';
  }
}
