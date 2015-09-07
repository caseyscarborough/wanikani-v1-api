# WaniKani API for Java

This repository contains the Java client for the [WaniKani API](https://www.wanikani.com/api).

## Getting the Library

Add the following to your pom.xml file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.caseyscarborough</groupId>
        <artifactId>wanikani-api</artifactId>
        <version>master</version>
    </dependency>
</dependencies>
```

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
List<Item> recentUnlocks = client.getRecentUnlocks();

// Retrieves the last 50 items
List<Item> recentUnlocks = client.getRecentUnlocks(50);
```

### Critical Items List

Retrieves the list of user's critical items, sorted by ascending percentage.

This method takes an optional parameter for maximum percentage, that will only retrieve items with a percentage lower than it. This defaults to 75%.

```java
// Get all critical items lower than 75%
List<Item> criticalItems = client.getCriticalItems();

// Get critical items lower than 95%
List<Item> criticalItems = client.getCriticalItems(95);
```

### Radicals List

Retrieves a full list of user's radicals with statistics, sorted by ascending level. A list of specific levels can be passed in to return only radicals from those levels.

```java
// Get all user's radicals
List<Radical> radicals = client.getRadicals();

// Get radicals from level 50, 55, and 60
List<Radical> radicals = client.getRadicals(50, 55, 60);

// Get statistics about a radical
Statistics stats = radicals.get(0).getStatistics();
```

### Kanji List

Retrieves a full list of user's kanji with statistics, sorted by ascending level. A list of specific levels can be passed in to return only kanji from those levels.

```java
// Get all user's kanji
List<Kanji> kanji = client.getKanji();

// Get kanjis from levels 1, 2, and 3
List<Kanji> kanji = client.getKanji(1, 2, 3);

// Get statistics about a kanji
Statistics stats = kanji.get(0).getStatistics();
```

### Vocabulary List

Retrieves a full list of user's vocabulary with statistics, sorted by ascending level. A list of specific levels can be passed in to return only vocabulary from those levels.

```java
// Get all user's vocabulary items
List<Vocabulary> vocabulary = client.getVocabulary();

// Get vocabulary from levels 10 and 11
List<Vocabulary> vocabulary = client.getVocabulary(10, 11);

// Get statistics about a vocabulary item
Statistics stats = vocabulary.get(0).getStatistics();
```