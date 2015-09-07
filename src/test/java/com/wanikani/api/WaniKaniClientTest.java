package com.wanikani.api;

import com.wanikani.api.config.Configuration;
import com.wanikani.api.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class WaniKaniClientTest {

  private WaniKaniClient client;

  @Before
  public void setUp() {
    client = new MockWaniKaniClient("test-api-key");
  }

  @Test
  public void testGetUserInformation() throws Exception {
    UserInformation info = client.getUserInformation();
    assertEquals("test-user", info.getUsername());
    assertEquals(Configuration.GRAVATAR_BASE_URL + info.getGravatar(), info.getGravatarUrl());
    assertEquals(new Date(1439205754000L), info.getCreationDate());
    assertEquals(null, info.getVacationDate());
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
    assertEquals(125, srs.getGuru().getTotal());
  }

  @Test
  public void testRecentUnlocksWithLimit() {
    List<Item> items = client.getRecentUnlocks(3);
    assertEquals(3, items.size());

    Item first = items.get(0);
    assertEquals("vocabulary", first.getType());
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
    assertEquals("vocabulary", first.getType());
    assertEquals("〜才", first.getCharacter());
    assertEquals("さい", first.getKana());
    assertEquals("years old, age", first.getMeaning());
    assertEquals(2, first.getLevel());
    assertEquals(new Date(1441550030000L), first.getUnlockedDate());
  }

  @Test
  public void testCriticalItemsWithPercentage() {
    List<CriticalItem> items = client.getCriticalItems(80);
    assertEquals(4, items.size());

    for (CriticalItem item : items) {
      assertTrue(Integer.parseInt(item.getPercentage()) < 80);
    }

    CriticalItem first = items.get(0);
    assertEquals("vocabulary", first.getType());
    assertEquals("八日", first.getCharacter());
    assertEquals("ようか", first.getKana());
    assertEquals("eight days, day eight, eighth day", first.getMeaning());
    assertEquals("67", first.getPercentage());
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
  public void testGetKanjiAtLevel1And2() {
    List<Kanji> kanji = client.getKanji(1, 2);
    assertEquals(56, kanji.size());

    Kanji first = kanji.get(0);
    assertEquals("口", first.getCharacter());
    assertEquals("こう, く", first.getOnyomi());
    assertEquals("くち", first.getKunyomi());
    assertNull(first.getNanori());
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


}
