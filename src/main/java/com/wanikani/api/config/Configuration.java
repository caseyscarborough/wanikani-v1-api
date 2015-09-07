package com.wanikani.api.config;

public class Configuration {

  public static final String API_VERSION = "v1.4";
  public static final String API_BASE_URL = "https://www.wanikani.com/api/" + API_VERSION;

  public static final String VOCABULARY_BASE_URL = "https://www.wanikani.com/vocabulary/";
  public static final String KANJI_BASE_URL = "https://www.wanikani.com/kanji/";
  public static final String RADICAL_BASE_URL = "https://www.wanikani.com/radical/";

  public static final String GRAVATAR_BASE_URL = "https://www.gravatar.com/avatar/";

  public static final int RECENT_UNLOCKS_MIN_LIMIT = 1;
  public static final int RECENT_UNLOCKS_MAX_LIMIT = 100;
  public static final int CRITICAL_ITEMS_MIN_PERCENTAGE = 0;
  public static final int CRITICAL_ITEMS_MAX_PERCENTAGE = 100;
}
