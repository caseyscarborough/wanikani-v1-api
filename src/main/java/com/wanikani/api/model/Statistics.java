package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;
import java.util.List;

public class Statistics {

  private String srs;
  private Integer srsNumeric;
  private Boolean burned;
  private Integer meaningCorrect;
  private Integer meaningIncorrect;
  private Integer meaningMaxStreak;
  private Integer meaningCurrentStreak;
  private Integer readingCorrect;
  private Integer readingIncorrect;
  private Integer readingMaxStreak;
  private Integer readingCurrentStreak;
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

  public Integer getSrsNumeric() {
    return srsNumeric;
  }

  public void setSrsNumeric(Integer srsNumeric) {
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

  public Boolean getBurned() {
    return burned;
  }

  public void setBurned(Boolean burned) {
    this.burned = burned;
  }

  public Date getBurnedDate() {
    return burnedDate;
  }

  public void setBurnedDate(Date burnedDate) {
    this.burnedDate = burnedDate;
  }

  public Integer getMeaningCorrect() {
    return meaningCorrect;
  }

  public void setMeaningCorrect(Integer meaningCorrect) {
    this.meaningCorrect = meaningCorrect;
  }

  public Integer getMeaningIncorrect() {
    return meaningIncorrect;
  }

  public void setMeaningIncorrect(Integer meaningIncorrect) {
    this.meaningIncorrect = meaningIncorrect;
  }

  public Integer getMeaningMaxStreak() {
    return meaningMaxStreak;
  }

  public void setMeaningMaxStreak(Integer meaningMaxStreak) {
    this.meaningMaxStreak = meaningMaxStreak;
  }

  public Integer getMeaningCurrentStreak() {
    return meaningCurrentStreak;
  }

  public void setMeaningCurrentStreak(Integer meaningCurrentStreak) {
    this.meaningCurrentStreak = meaningCurrentStreak;
  }

  public Integer getReadingCorrect() {
    return readingCorrect;
  }

  public void setReadingCorrect(Integer readingCorrect) {
    this.readingCorrect = readingCorrect;
  }

  public Integer getReadingIncorrect() {
    return readingIncorrect;
  }

  public void setReadingIncorrect(Integer readingIncorrect) {
    this.readingIncorrect = readingIncorrect;
  }

  public Integer getReadingMaxStreak() {
    return readingMaxStreak;
  }

  public void setReadingMaxStreak(Integer readingMaxStreak) {
    this.readingMaxStreak = readingMaxStreak;
  }

  public Integer getReadingCurrentStreak() {
    return readingCurrentStreak;
  }

  public void setReadingCurrentStreak(Integer readingCurrentStreak) {
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
