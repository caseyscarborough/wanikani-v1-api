package com.wanikani.api.model;

import com.wanikani.api.config.Configuration;

public enum ItemType {

  RADICAL("radical", Configuration.RADICAL_BASE_URL),
  KANJI("kanji", Configuration.KANJI_BASE_URL),
  VOCABULARY("vocabulary", Configuration.VOCABULARY_BASE_URL);

  private final String name;
  private final String baseUrl;

  ItemType(String name, String baseUrl) {
    this.name = name;
    this.baseUrl = baseUrl;
  }

  public static ItemType findByName(String name) {
    for (ItemType type : ItemType.values()) {
      if (type.name.equals(name)) {
        return type;
      }
    }
    throw new IllegalArgumentException("No ItemType with name: " + name);
  }

  public String getName() {
    return name;
  }

  public String getBaseUrl() {
    return baseUrl;
  }
}
