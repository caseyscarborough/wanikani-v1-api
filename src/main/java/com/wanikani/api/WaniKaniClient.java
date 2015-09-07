package com.wanikani.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.wanikani.api.model.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WaniKaniClient {

  private String apiKey;
  private ObjectMapper mapper;

  public WaniKaniClient(String apiKey) {
    if (apiKey == null || apiKey.trim().isEmpty()) {
      throw new RuntimeException("An API key is required to make requests to the API. Get your API key at https://www.wanikani.com/account.");
    }
    this.apiKey = apiKey;
    mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

  }

  private String getBaseUrl() {
    return Configuration.API_BASE_URL + "/user/" + apiKey;
  }

  public UserInformation getUserInformation() {
    return request("/user-information", new TypeReference<Response>() {}).getUserInformation();
  }

  public StudyQueue getStudyQueue() {
    return request("/study-queue", new TypeReference<Response<StudyQueue>>() {}).getRequestedInformation();
  }

  public LevelProgression getLevelProgression() {
    return request("/level-progression", new TypeReference<Response<LevelProgression>>() {}).getRequestedInformation();
  }

  public SrsDistribution getSrsDistribution() {
    return request("/srs-distribution", new TypeReference<Response<SrsDistribution>>() {}).getRequestedInformation();
  }

  public List<Item> getRecentUnlocksList() {
    return getRecentUnlocksList(null);
  }

  public List<Item> getRecentUnlocksList(Integer limit) {
    String endpoint = "/recent-unlocks";
    if (limit != null) {
      endpoint += "/" + limit;
    }
    return request(endpoint, new TypeReference<Response<List<Item>>>() {}).getRequestedInformation();
  }

  public List<CriticalItem> getCriticalItemsList() {
    return getCriticalItemsList(null);
  }

  public List<CriticalItem> getCriticalItemsList(Integer minimumPercentage) {
    String endpoint = "/critical-items";
    if (minimumPercentage != null) {
      endpoint += "/" + minimumPercentage;
    }
    return request(endpoint, new TypeReference<Response<List<CriticalItem>>>() {}).getRequestedInformation();
  }

  public List<Radical> getRadicalsList() {
    return getRadicalsList(null);
  }

  public List<Radical> getRadicalsList(Integer level) {
    String endpoint = "/radicals";
    if (level != null) {
      endpoint += "/" + level;
    }
    return request(endpoint, new TypeReference<Response<List<Radical>>>() {}).getRequestedInformation();
  }

  public List<Kanji> getKanjiList() {
    return getKanjiList(null);
  }

  public List<Kanji> getKanjiList(Integer level) {
    String endpoint = "/kanji";
    if (level != null) {
      endpoint += "/" + level;
    }
    return request(endpoint, new TypeReference<Response<List<Kanji>>>() {}).getRequestedInformation();
  }

  public List<Vocabulary> getVocabularyList() {
    return getVocabularyList(null);
  }

  public List<Vocabulary> getVocabularyList(Integer level) {
    if (level == null) {
      return request("/vocabulary", new TypeReference<Response<GeneralWrapper<List<Vocabulary>>>>() {}).getRequestedInformation().getGeneral();
    }

    return request("/vocabulary/" + level, new TypeReference<Response<List<Vocabulary>>>() {}).getRequestedInformation();
  }

  private <T> T request(String endpoint, TypeReference<T> reference) {
    try {
      URL obj = new URL(getBaseUrl() + endpoint);
      HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
      connection.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      return mapper.readValue(response.toString(), reference);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }
}
