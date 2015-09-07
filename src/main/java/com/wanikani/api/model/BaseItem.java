package com.wanikani.api.model;

public abstract class BaseItem {

  protected String character;
  protected int level;
  protected String meaning;

  public BaseItem() {
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  @Override
  public String toString() {
    return "BaseItem{" +
        "character='" + character + '\'' +
        ", level='" + level + '\'' +
        ", meaning='" + meaning + '\'' +
        '}';
  }
}
