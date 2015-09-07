# WaniKani API for Java

This repository contains the Java client for the [WaniKani API](https://www.wanikani.com/api).

## Usage

```java
WaniKaniClient client = new WaniKaniClient("your-api-key");

// use client methods
UserInformation info = client.getUserInformation();
```

## Methods

### User Information

Retrieves information about the user associated with the API key.

```java
UserInformation info = client.getUserInformation();
```

### Study Queue

Retrieves information about the user's current study queue.

```java
StudyQueue queue = client.getStudyQueue();
```

### Level Progression

Retrieves the user's current level radical and kanji progression.

```java
LevelProgression progress = client.getLevelProgression();
```

### SRS Distribution

Retrieves information about the user's current SRS Distribution.

```java
SrsDistribution distribution = client.getSrsDistribution();
```

### Recent Unlocks List

Retrieves the user's recently unlocked items. A limit parameter can be passed in, with a minimum of 1, maximum of 100, and defaults to 10.

```java
// Retrieves the most recent 10
List<Item> recentUnlocks = client.getRecentUnlocksList();

// Retrieves the last 50 items
List<Item> recentUnlocks = client.getRecentUnlocksList(50);
```

### Critical Items List

Retrieves the list of user's critical items, sorted by ascending percentage.

This method takes an optional parameter for maximum percentage, that will only retrieve items with a percentage lower than it. This defaults to 75%.

```java
// Get all critical items lower than 75%
List<Item> criticalItems = client.getCriticalItemsList();

// Get critical items lower than 95%
List<Item> criticalItems = client.getCriticalItemsList(95);
```

### Radicals List

Retrieves a full list of user's radicals with statistics, sorted by ascending level. A specific level can be passed in to return only radicals from that level.

```java
// Get all user's radicals
List<Radical> radicals = client.getRadicalsList();

// Get radicals from level 10
List<Radical> radicals = client.getRadicalsList(10);

// Get statistics about a radical
Statistics stats = radicals.get(0).getStatistics();
```

### Kanji List

Retrieves a full list of user's kanji with statistics, sorted by ascending level. A specific level can be passed in to return only kanji from that level.

```java
// Get all user's kanji
List<Kanji> kanji = client.getKanjiList();

// Get kanjis from level 25
List<Kanji> kanji = client.getKanjiList(25);

// Get statistics about a kanji
Statistics stats = kanji.get(0).getStatistics();
```

### Vocabulary List

Retrieves a full list of user's vocabulary with statistics, sorted by ascending level. A specific level can be passed in to return only vocabulary from that level.

```java
// Get all user's vocabulary items
List<Vocabulary> vocabulary = client.getVocabularyList();

// Get vocabulary from level 30
List<Vocabulary> vocabulary = client.getVocabularyList(30);

// Get statistics about a vocabulary item
Statistics stats = vocabulary.get(0).getStatistics();
```