package com.wanikani.api;

import com.wanikani.api.config.Configuration;
import com.wanikani.api.exception.WaniKaniException;
import com.wanikani.api.http.HttpClient;
import com.wanikani.api.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WaniKaniClientTest {

  private class MockHttpClient extends HttpClient {

    @Override
    public String request(String url) {
      String jsonFile = url.replaceAll(Configuration.API_BASE_URL + "/user/api-key/", "").replaceAll("/", "-") + ".json";
      InputStream in = this.getClass().getClassLoader().getResourceAsStream(jsonFile);
      Scanner s = new Scanner(in).useDelimiter("\\A");
      return s.hasNext() ? s.next() : "";
    }
  }

  private HttpClient httpClient;
  private WaniKaniClient client;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() {
    client = new WaniKaniClient("api-key");
    httpClient = mock(MockHttpClient.class);
    when(httpClient.request(Matchers.anyString())).thenCallRealMethod();
    client.setClient(httpClient);
  }

  @Test
  public void testClientCreationThrowsExceptionWhenApiKeyIsNull() {
    expectedException.expect(WaniKaniException.class);
    expectedException.expectMessage("An API key is required to make requests to the API. Get your API key at https://www.wanikani.com/account.");
    client = new WaniKaniClient(null);
  }

  @Test
  public void testWhenUserDoesntExist() {
    expectedException.expect(WaniKaniException.class);
    expectedException.expectMessage("User does not exist.");
    client.getKanji(24);
  }

  @Test
  public void testGetUserInformation() throws Exception {
    UserInformation info = client.getUserInformation();
    assertEquals("test-user", info.getUsername());
    assertEquals(Configuration.GRAVATAR_BASE_URL + info.getGravatar(), info.getGravatarUrl());
    assertEquals(new Date(1439205754000L), info.getCreationDate());
    assertEquals(null, info.getVacationDate());
    assertEquals("", info.getTwitter());
    assertEquals(null, info.getWebsite());
    assertEquals(23, info.getTopicsCount());
    assertEquals(1, info.getPostsCount());
    assertEquals("", info.getAbout());
    assertEquals(2, info.getLevel());
    assertEquals("Turtles", info.getTitle());
    assertFalse(info.isInVacationMode());
  }

  @Test
  public void testGetStudyQueue() {
    StudyQueue queue = client.getStudyQueue();
    assertEquals(12, queue.getLessonsAvailable());
    assertEquals(17, queue.getReviewsAvailable());
    assertEquals(new Date(1441628018000L), queue.getNextReviewDate());
    assertEquals(0, queue.getReviewsAvailableNextHour());
    assertEquals(23, queue.getReviewsAvailableNextDay());
  }

  @Test
  public void testGetLevelProgression() {
    LevelProgression progress = client.getLevelProgression();
    assertEquals(18, progress.getRadicalsProgress());
    assertEquals(18, progress.getRadicalsTotal());
    assertEquals(7, progress.getKanjiProgress());
    assertEquals(7, progress.getKanjiTotal());
  }

  @Test
  public void testGetSrsDistribution() {
    SrsDistribution srs = client.getSrsDistribution();
    assertEquals(0, srs.getApprentice().getRadicals());
    assertEquals(60, srs.getGuru().getRadicals());
    assertEquals(23, srs.getGuru().getKanji());
    assertEquals(0, srs.getBurned().getVocabulary());
    assertEquals(125, srs.getGuru().getTotal());
  }

  @Test
  public void testRecentUnlocksWithLimit() {
    List<Item> items = client.getRecentUnlocks(3);
    assertEquals(3, items.size());

    Item first = items.get(0);
    assertEquals(ItemType.VOCABULARY, first.getType());
    assertEquals("丸い", first.getCharacter());
    assertEquals("まるい", first.getKana());
    assertEquals("circular, round, spherical", first.getMeaning());
    assertEquals(2, first.getLevel());
    assertEquals(new Date(1441458973000L), first.getUnlockedDate());
  }

  @Test
  public void testRecentUnlocksWithNoLimit() {
    List<Item> items = client.getRecentUnlocks();
    assertEquals(10, items.size());

    Item first = items.get(0);
    assertEquals(ItemType.VOCABULARY, first.getType());
    assertEquals("〜才", first.getCharacter());
    assertEquals("さい", first.getKana());
    assertEquals("years old, age", first.getMeaning());
    assertEquals(2, first.getLevel());
    assertEquals(new Date(1441550030000L), first.getUnlockedDate());
  }

  @Test
  public void testRecentUnlocksWhenLimitIsAboveTheMaximum() throws Exception{
    List<Item> items = client.getRecentUnlocks(300);
    verify(httpClient, times(1)).request(getBaseUrl() + "recent-unlocks/" + Configuration.RECENT_UNLOCKS_MAX_LIMIT);
    assertEquals(Configuration.RECENT_UNLOCKS_MAX_LIMIT, items.size());
  }

  @Test
  public void testRecentUnlocksWhenLimitIsBelowMinimum() throws Exception {
    List<Item> items = client.getRecentUnlocks(-20);
    verify(httpClient, times(1)).request(getBaseUrl() + "recent-unlocks/" + Configuration.RECENT_UNLOCKS_MIN_LIMIT);
    assertEquals(Configuration.RECENT_UNLOCKS_MIN_LIMIT, items.size());
  }

  @Test
  public void testCriticalItemsWithPercentage() {
    List<CriticalItem> items = client.getCriticalItems(80);
    assertEquals(4, items.size());

    for (CriticalItem item : items) {
      assertTrue(Integer.parseInt(item.getPercentage()) < 80);
    }

    CriticalItem first = items.get(0);
    assertEquals(ItemType.VOCABULARY, first.getType());
    assertEquals("八日", first.getCharacter());
    assertEquals("ようか", first.getKana());
    assertEquals("eight days, day eight, eighth day", first.getMeaning());
    assertEquals("67", first.getPercentage());
  }

  @Test
  public void testCriticalItemsWithTooHighOfAPercentage() throws Exception {
    List<CriticalItem> items = client.getCriticalItems(Configuration.CRITICAL_ITEMS_MAX_PERCENTAGE + 123);
    verify(httpClient, times(1)).request(getBaseUrl() + "critical-items/" + Configuration.CRITICAL_ITEMS_MAX_PERCENTAGE);

    assertEquals(222, items.size());
  }

  @Test
  public void testCriticalItemsWithTooLowOfAPercentage() throws Exception {
    List<CriticalItem> items = client.getCriticalItems(Configuration.CRITICAL_ITEMS_MIN_PERCENTAGE - 123);
    verify(httpClient, times(1)).request(getBaseUrl() + "critical-items/" + Configuration.CRITICAL_ITEMS_MIN_PERCENTAGE);

    assertEquals(0, items.size());
  }

  @Test
  public void testCriticalItemsWithoutPercentage() {
    List<CriticalItem> items = client.getCriticalItems();
    assertEquals(1, items.size());

    CriticalItem item = items.get(0);
    assertEquals("67", item.getPercentage());
  }

  @Test
  public void testGetRadicalsAtLevel1And2() {
    List<Radical> radicals = client.getRadicals(1, 2);
    assertEquals(60, radicals.size());

    Radical first = radicals.get(0);
    assertEquals("一", first.getCharacter());
    assertEquals("ground", first.getMeaning());
    assertNull(first.getImage());
    assertEquals(1, first.getLevel());

    Statistics stats = first.getStatistics();
    assertEquals("guru", stats.getSrs());
    assertFalse(stats.getBurned());
    assertEquals(6, stats.getSrsNumeric());
    assertEquals(1439205754000L, stats.getUnlockedDate().getTime());
    assertEquals("one", stats.getUserSynonyms().get(0));
  }

  @Test
  public void testGetRadicalsWithInvalidLevel() {
    expectedException.expect(WaniKaniException.class);
    expectedException.expectMessage("Levels requested invalid.");
    client.getRadicals(123);
  }

  @Test
  public void testGetKanjiAtLevel1And2() {
    List<Kanji> kanji = client.getKanji(1, 2);
    assertEquals(56, kanji.size());

    Kanji first = kanji.get(0);
    assertEquals("口", first.getCharacter());
    assertEquals("こう, く", first.getOnyomi());
    assertEquals("くち", first.getKunyomi());
    assertEquals("onyomi", first.getImportantReading());
    assertNull(first.getNanori());
    assertTrue(first.isUnlocked());
  }

  @Test
  public void testGetVocabularyAtLevel50And60() {
    List<Vocabulary> vocabulary = client.getVocabulary(50, 60);
    assertEquals(153, vocabulary.size());

    Vocabulary last = vocabulary.get(vocabulary.size() - 1);
    assertEquals("感慨無量", last.getCharacter());
    assertEquals("deep emotion, deeply moved, filled with emotion", last.getMeaning());
    assertNull(last.getStatistics());
    assertFalse(last.isUnlocked());
    assertEquals(Configuration.VOCABULARY_BASE_URL + last.getCharacter(), last.getInformationUrl());
  }

  @Test
  public void testGetVocabularyWithNoLevelSpecified() {
    List<Vocabulary> vocabulary = client.getVocabulary();
    assertEquals(132, vocabulary.size());
  }

  @Test
  public void testGetVocabularyWithInvalidLevel() {
    expectedException.expect(WaniKaniException.class);
    expectedException.expectMessage("Levels requested invalid.");
    client.getVocabulary(100);
  }

  private String getBaseUrl() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method getBaseUrl = client.getClass().getDeclaredMethod("getBaseUrl");
    getBaseUrl.setAccessible(true);
    return (String) getBaseUrl.invoke(client);
  }

}
