package com.wanikani.api;

import com.wanikani.api.config.Configuration;
import com.wanikani.api.http.HttpClient;

import java.io.InputStream;
import java.util.Scanner;

public class MockHttpClient extends HttpClient {


  @Override
  public String request(String url) {
    String jsonFile = url.replaceAll(Configuration.API_BASE_URL + "/user/api-key/", "").replaceAll("/", "-") + ".json";
    InputStream in = this.getClass().getClassLoader().getResourceAsStream(jsonFile);
    Scanner s = new Scanner(in).useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
  }
}
