package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;
import java.util.List;

public class Statistics {

  private String srs;
  private int srsNumeric;
  private boolean burned;
  private int meaningCorrect;
  private int meaningIncorrect;
  private int meaningMaxStreak;
  private int meaningCurrentStreak;
  private int readingCorrect;
  private int readingIncorrect;
  private int readingMaxStreak;
  private int readingCurrentStreak;
  private String meaningNote;
  private List<String> userSynonyms;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date unlockedDate;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date availableDate;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date burnedDate;


  public Statistics() {
  }

  public String getSrs() {
    return srs;
  }

  public void setSrs(String srs) {
    this.srs = srs;
  }

  public int getSrsNumeric() {
    return srsNumeric;
  }

  public void setSrsNumeric(int srsNumeric) {
    this.srsNumeric = srsNumeric;
  }

  public Date getUnlockedDate() {
    return unlockedDate;
  }

  public void setUnlockedDate(Date unlockedDate) {
    this.unlockedDate = unlockedDate;
  }

  public Date getAvailableDate() {
    return availableDate;
  }

  public void setAvailableDate(Date availableDate) {
    this.availableDate = availableDate;
  }

  public boolean getBurned() {
    return burned;
  }

  public void setBurned(boolean burned) {
    this.burned = burned;
  }

  public Date getBurnedDate() {
    return burnedDate;
  }

  public void setBurnedDate(Date burnedDate) {
    this.burnedDate = burnedDate;
  }

  public int getMeaningCorrect() {
    return meaningCorrect;
  }

  public void setMeaningCorrect(int meaningCorrect) {
    this.meaningCorrect = meaningCorrect;
  }

  public int getMeaningIncorrect() {
    return meaningIncorrect;
  }

  public void setMeaningIncorrect(int meaningIncorrect) {
    this.meaningIncorrect = meaningIncorrect;
  }

  public int getMeaningMaxStreak() {
    return meaningMaxStreak;
  }

  public void setMeaningMaxStreak(int meaningMaxStreak) {
    this.meaningMaxStreak = meaningMaxStreak;
  }

  public int getMeaningCurrentStreak() {
    return meaningCurrentStreak;
  }

  public void setMeaningCurrentStreak(int meaningCurrentStreak) {
    this.meaningCurrentStreak = meaningCurrentStreak;
  }

  public int getReadingCorrect() {
    return readingCorrect;
  }

  public void setReadingCorrect(int readingCorrect) {
    this.readingCorrect = readingCorrect;
  }

  public int getReadingIncorrect() {
    return readingIncorrect;
  }

  public void setReadingIncorrect(int readingIncorrect) {
    this.readingIncorrect = readingIncorrect;
  }

  public int getReadingMaxStreak() {
    return readingMaxStreak;
  }

  public void setReadingMaxStreak(int readingMaxStreak) {
    this.readingMaxStreak = readingMaxStreak;
  }

  public int getReadingCurrentStreak() {
    return readingCurrentStreak;
  }

  public void setReadingCurrentStreak(int readingCurrentStreak) {
    this.readingCurrentStreak = readingCurrentStreak;
  }

  public String getMeaningNote() {
    return meaningNote;
  }

  public void setMeaningNote(String meaningNote) {
    this.meaningNote = meaningNote;
  }

  public List<String> getUserSynonyms() {
    return userSynonyms;
  }

  public void setUserSynonyms(List<String> userSynonyms) {
    this.userSynonyms = userSynonyms;
  }

  @Override
  public String toString() {
    return "Statistics{" +
        "srs='" + srs + '\'' +
        ", srsNumeric=" + srsNumeric +
        ", unlockedDate=" + unlockedDate +
        ", availableDate=" + availableDate +
        ", burned=" + burned +
        ", burnedDate=" + burnedDate +
        ", meaningCorrect=" + meaningCorrect +
        ", meaningIncorrect=" + meaningIncorrect +
        ", meaningMaxStreak=" + meaningMaxStreak +
        ", meaningCurrentStreak=" + meaningCurrentStreak +
        ", readingCorrect=" + readingCorrect +
        ", readingIncorrect=" + readingIncorrect +
        ", readingMaxStreak=" + readingMaxStreak +
        ", readingCurrentStreak=" + readingCurrentStreak +
        ", meaningNote='" + meaningNote + '\'' +
        ", userSynonyms='" + userSynonyms + '\'' +
        '}';
  }
}
