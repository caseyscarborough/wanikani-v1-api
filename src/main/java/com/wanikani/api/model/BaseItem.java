package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.ItemTypeDeserializer;

public abstract class BaseItem {

  protected String character;
  protected int level;
  protected String meaning;

  @JsonDeserialize(using = ItemTypeDeserializer.class)
  protected ItemType type;

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

  public ItemType getType() {
    return type;
  }

  public void setType(ItemType type) {
    this.type = type;
  }

  public String getInformationUrl() {
    return type.getBaseUrl() + character;
  }

  @Override
  public String toString() {
    return "BaseItem{" +
        "character='" + character + '\'' +
        ", level='" + level + '\'' +
        ", meaning='" + meaning + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
