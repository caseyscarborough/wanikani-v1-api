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
import java.util.Arrays;
import java.util.List;

/**
 * The main class for interacting with the WaniKani API.
 *
 * Usage:
 *
 * <pre>
 * {@code
 * WaniKaniClient client = new WaniKaniClient("your-api-key");
 *
 * // use client methods
 * UserInformation info = client.getUserInformation();
 * }
 * </pre>
 */
public class WaniKaniClient {

  /**
   * The user's API key. Required for calls to the API.
   */
  private String apiKey;

  public WaniKaniClient(String apiKey) {
    if (apiKey == null || apiKey.trim().isEmpty()) {
      throw new RuntimeException("An API key is required to make requests to the API. Get your API key at https://www.wanikani.com/account.");
    }
    this.apiKey = apiKey;
  }

  private String getBaseUrl() {
    return Configuration.API_BASE_URL + "/user/" + apiKey + "/";
  }

  /**
   * Retrieves information about the user associated with the API key.
   * @return The user's information
   */
  public UserInformation getUserInformation() {
    return request("user-information", new TypeReference<Response>() {}).getUserInformation();
  }

  /**
   * Retrieves information about the user's current study queue.
   * @return The study queue information
   */
  public StudyQueue getStudyQueue() {
    return request("study-queue", new TypeReference<Response<StudyQueue>>() {}).getRequestedInformation();
  }

  /**
   * Retrieves the user's current level radical and kanji progression.
   * @return The user's current level progression
   */
  public LevelProgression getLevelProgression() {
    return request("level-progression", new TypeReference<Response<LevelProgression>>() {}).getRequestedInformation();
  }

  /**
   * Retrieves information about the user's current SRS Distribution.
   * @return The user's current SRS Distribution.
   */
  public SrsDistribution getSrsDistribution() {
    return request("srs-distribution", new TypeReference<Response<SrsDistribution>>() {}).getRequestedInformation();
  }

  /**
   * Retrieves the user's recently unlocked items, with the default limit of ten.
   * @return The list of recently unlocked items.
   */
  public List<Item> getRecentUnlocks() {
    return getRecentUnlocks(null);
  }

  /**
   * Retrieves the user's recently unlocked items.
   * @param limit the number of items to retrieve, minimum of 1, maximum of 100.
   * @return The list of recently unlocked items.
   */
  public List<Item> getRecentUnlocks(Integer limit) {
    String endpoint = "recent-unlocks";
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

  /**
   * Retrieves the user's critical items below 75%.
   * @return The list of critical items.
   */
  public List<CriticalItem> getCriticalItems() {
    return getCriticalItems(null);
  }

  /**
   * Retrieves the user's critical items below a given percentage.
   * @param maximumPercentage The maximum percentage to retrieve items for.
   * @return The list of critical items.
   */
  public List<CriticalItem> getCriticalItems(Integer maximumPercentage) {
    String endpoint = "critical-items";
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

  /**
   * Retrieves a list of radicals. No parameters will retrieve all of the user's
   * currently unlocked radicals. Any number of levels may be passed in to retrieve
   * radicals from those levels.
   * @param levels The levels to retrieve radicals for, omit for just the user's unlocked radicals.
   * @return The list of radicals.
   */
  public List<Radical> getRadicals(int ... levels) {
    String endpoint = "radicals";
    if (levels.length > 0) {
      endpoint += "/" + Arrays.toString(levels).replaceAll("[\\s\\[\\]]", "");
    }
    return request(endpoint, new TypeReference<Response<List<Radical>>>() {}).getRequestedInformation();
  }

  /**
   * Retrieves a list of kanji. No parameters will retrieve all of the user's
   * currently unlocked kanji. Any number of levels may be passed in to retrieve
   * kanji from those levels.
   * @param levels The levels to retrieve kanji for, omit for just the user's unlocked kanji.
   * @return The list of kanji.
   */
  public List<Kanji> getKanji(int ... levels) {
    String endpoint = "kanji";
    if (levels.length > 0) {
      endpoint += "/" + Arrays.toString(levels).replaceAll("[\\s\\[\\]]", "");
    }
    return request(endpoint, new TypeReference<Response<List<Kanji>>>() {}).getRequestedInformation();
  }

  /**
   * Retrieves a list of vocabulary. No parameters will retrieve all of the user's
   * currently unlocked vocabulary. Any number of levels may be passed in to retrieve
   * vocabulary from those levels.
   * @param levels The levels to retrieve vocabulary for, omit for just the user's unlocked vocabulary.
   * @return The list of vocabulary.
   */
  public List<Vocabulary> getVocabulary(int ... levels) {
    if (levels.length == 0) {
      return request("vocabulary", new TypeReference<Response<GeneralWrapper<List<Vocabulary>>>>() {}).getRequestedInformation().getGeneral();
    }

    return request("vocabulary/" + Arrays.toString(levels).replaceAll("[\\s\\[\\]]", ""), new TypeReference<Response<List<Vocabulary>>>() {}).getRequestedInformation();
  }

  protected  <T extends Response> T request(String endpoint, TypeReference<T> reference) throws WaniKaniException {
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
