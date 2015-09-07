package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyQueue {

  @JsonProperty("lessons_available")
  private Integer lessonsAvailable;

  @JsonProperty("reviews_available")
  private Integer reviewsAvailable;

  @JsonProperty("next_review_date")
  private Long nextReviewDate;

  @JsonProperty("reviews_available_next_hour")
  private Integer reviewsAvailableNextHour;

  @JsonProperty("reviews_available_next_day")
  private Integer reviewsAvailableNextDay;

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

  public Long getNextReviewDate() {
    return nextReviewDate;
  }

  public void setNextReviewDate(Long nextReviewDate) {
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
