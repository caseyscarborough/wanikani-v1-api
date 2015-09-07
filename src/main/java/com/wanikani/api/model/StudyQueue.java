package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;

public class StudyQueue {

  private Integer lessonsAvailable;
  private Integer reviewsAvailable;
  private Integer reviewsAvailableNextHour;
  private Integer reviewsAvailableNextDay;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date nextReviewDate;

  public StudyQueue() {
  }

  public Integer getLessonsAvailable() {
    return lessonsAvailable;
  }

  public void setLessonsAvailable(Integer lessonsAvailable) {
    this.lessonsAvailable = lessonsAvailable;
  }

  public Integer getReviewsAvailable() {
    return reviewsAvailable;
  }

  public void setReviewsAvailable(Integer reviewsAvailable) {
    this.reviewsAvailable = reviewsAvailable;
  }

  public Date getNextReviewDate() {
    return nextReviewDate;
  }

  public void setNextReviewDate(Date nextReviewDate) {
    this.nextReviewDate = nextReviewDate;
  }

  public Integer getReviewsAvailableNextHour() {
    return reviewsAvailableNextHour;
  }

  public void setReviewsAvailableNextHour(Integer reviewsAvailableNextHour) {
    this.reviewsAvailableNextHour = reviewsAvailableNextHour;
  }

  public Integer getReviewsAvailableNextDay() {
    return reviewsAvailableNextDay;
  }

  public void setReviewsAvailableNextDay(Integer reviewsAvailableNextDay) {
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
