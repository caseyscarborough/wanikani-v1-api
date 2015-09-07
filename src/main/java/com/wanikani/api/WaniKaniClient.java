package com.wanikani.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wanikani.api.config.Configuration;
import com.wanikani.api.exception.WaniKaniException;
import com.wanikani.api.json.ObjectMapperFactory;
import com.wanikani.api.model.*;
import com.wanikani.api.model.Error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WaniKaniClient {

  private String apiKey;

  public WaniKaniClient(String apiKey) {
    if (apiKey == null || apiKey.trim().isEmpty()) {
      throw new RuntimeException("An API key is required to make requests to the API. Get your API key at https://www.wanikani.com/account.");
    }
    this.apiKey = apiKey;
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

  public List<Item> getRecentUnlocks() {
    return getRecentUnlocks(null);
  }

  public List<Item> getRecentUnlocks(Integer limit) {
    String endpoint = "/recent-unlocks";
    if (limit != null) {
      if (limit > Configuration.RECENT_UNLOCKS_MAX_LIMIT) {
        limit = Configuration.RECENT_UNLOCKS_MAX_LIMIT;
      } else if (limit < Configuration.RECENT_UNLOCKS_MIN_LIMIT) {
        limit = Configuration.RECENT_UNLOCKS_MIN_LIMIT;
      }

      endpoint += "/" + limit;
    }
    return request(endpoint, new TypeReference<Response<List<Item>>>() {}).getRequestedInformation();
  }

  public List<CriticalItem> getCriticalItems() {
    return getCriticalItems(null);
  }

  public List<CriticalItem> getCriticalItems(Integer maximumPercentage) {
    String endpoint = "/critical-items";
    if (maximumPercentage != null) {
      if (maximumPercentage > Configuration.CRITICAL_ITEMS_MAX_PERCENTAGE) {
        maximumPercentage = Configuration.CRITICAL_ITEMS_MAX_PERCENTAGE;
      } else if (maximumPercentage < Configuration.CRITICAL_ITEMS_MIN_PERCENTAGE) {
        maximumPercentage = Configuration.CRITICAL_ITEMS_MIN_PERCENTAGE;
      }

      endpoint += "/" + maximumPercentage;
    }
    return request(endpoint, new TypeReference<Response<List<CriticalItem>>>() {}).getRequestedInformation();
  }

  public List<Radical> getRadicals() {
    return getRadicals(null);
  }

  public List<Radical> getRadicals(Integer level) {
    String endpoint = "/radicals";
    if (level != null) {
      endpoint += "/" + level;
    }
    return request(endpoint, new TypeReference<Response<List<Radical>>>() {}).getRequestedInformation();
  }

  public List<Kanji> getKanji() {
    return getKanji(null);
  }

  public List<Kanji> getKanji(Integer level) {
    String endpoint = "/kanji";
    if (level != null) {
      endpoint += "/" + level;
    }
    return request(endpoint, new TypeReference<Response<List<Kanji>>>() {}).getRequestedInformation();
  }

  public List<Vocabulary> getVocabulary() {
    return getVocabulary(null);
  }

  public List<Vocabulary> getVocabulary(Integer level) {
    if (level == null) {
      return request("/vocabulary", new TypeReference<Response<GeneralWrapper<List<Vocabulary>>>>() {}).getRequestedInformation().getGeneral();
    }

    return request("/vocabulary/" + level, new TypeReference<Response<List<Vocabulary>>>() {}).getRequestedInformation();
  }

  private <T extends Response> T request(String endpoint, TypeReference<T> reference) {
    String url = getBaseUrl() + endpoint;
    try {
      URL obj = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
      connection.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      T output = new ObjectMapperFactory().getInstance().readValue(response.toString(), reference);
      if (output.getError() != null) {
        Error error = output.getError();
        throw new WaniKaniException(error.getCode(), error.getMessage());
      }
      return output;
    } catch (JsonMappingException e) {
      throw new WaniKaniException("An error occurred parsing JSON. The input structure did not match the structure expected for the result type.", e);
    } catch (JsonParseException e) {
      throw new WaniKaniException("An error occurred parsing JSON with invalid format.", e);
    } catch (MalformedURLException e) {
      throw new WaniKaniException("URL was malformed: " + url, e);
    } catch (IOException e) {
      throw new WaniKaniException("An IO error occurred while performing request.", e);
    }
  }
}
