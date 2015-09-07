package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;

public class StudyQueue {

  private int lessonsAvailable;
  private int reviewsAvailable;
  private int reviewsAvailableNextHour;
  private int reviewsAvailableNextDay;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date nextReviewDate;

  public StudyQueue() {
  }

  public int getLessonsAvailable() {
    return lessonsAvailable;
  }

  public void setLessonsAvailable(int lessonsAvailable) {
    this.lessonsAvailable = lessonsAvailable;
  }

  public int getReviewsAvailable() {
    return reviewsAvailable;
  }

  public void setReviewsAvailable(int reviewsAvailable) {
    this.reviewsAvailable = reviewsAvailable;
  }

  public Date getNextReviewDate() {
    return nextReviewDate;
  }

  public void setNextReviewDate(Date nextReviewDate) {
    this.nextReviewDate = nextReviewDate;
  }

  public int getReviewsAvailableNextHour() {
    return reviewsAvailableNextHour;
  }

  public void setReviewsAvailableNextHour(int reviewsAvailableNextHour) {
    this.reviewsAvailableNextHour = reviewsAvailableNextHour;
  }

  public int getReviewsAvailableNextDay() {
    return reviewsAvailableNextDay;
  }

  public void setReviewsAvailableNextDay(int reviewsAvailableNextDay) {
    this.reviewsAvailableNextDay = reviewsAvailableNextDay;
  }

  @Override
  public String toString() {
    return "StudyQueue{" +
        "lessonsAvailable=" + lessonsAvailable +
        ", reviewsAvailable=" + reviewsAvailable +
        ", nextReviewDate=" + nextReviewDate +
        ", reviewsAvailableNextHour=" + reviewsAvailableNextHour +
        ", reviewsAvailableNextDay=" + reviewsAvailableNextDay +
        '}';
  }
}
