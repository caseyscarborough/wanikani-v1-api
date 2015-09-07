package com.wanikani.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanikani.api.json.ObjectMapperFactory;
import com.wanikani.api.model.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MockWaniKaniClient extends WaniKaniClient {

  public MockWaniKaniClient(String apiKey) {
    super(apiKey);
  }

  @Override
  protected <T extends Response> T request(String endpoint, TypeReference<T> reference) {
    InputStream in = this.getClass().getClassLoader().getResourceAsStream(endpoint.replaceAll("/", "-") + ".json");
    Scanner s = new Scanner(in).useDelimiter("\\A");
    String json = s.hasNext() ? s.next() : "";

    ObjectMapper mapper = new ObjectMapperFactory().getInstance();
    try {
      return mapper.readValue(json, reference);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
