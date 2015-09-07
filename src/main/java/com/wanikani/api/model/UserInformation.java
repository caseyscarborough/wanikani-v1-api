package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInformation {

  @JsonProperty("username")
  private String username;

  @JsonProperty("gravatar")
  private String gravatar;

  @JsonProperty("level")
  private Integer level;

  @JsonProperty("title")
  private String title;

  @JsonProperty("about")
  private String about;

  @JsonProperty("website")
  private String website;

  @JsonProperty("twitter")
  private String twitter;

  @JsonProperty("topics_count")
  private Integer topicsCount;

  @JsonProperty("posts_count")
  private Integer postsCount;

  @JsonProperty("creation_date")
  private Long creationDate;

  @JsonProperty("vacation_date")
  private Long vacationDate;

  public UserInformation() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getGravatar() {
    return gravatar;
  }

  public void setGravatar(String gravatar) {
    this.gravatar = gravatar;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  public Integer getTopicsCount() {
    return topicsCount;
  }

  public void setTopicsCount(Integer topicsCount) {
    this.topicsCount = topicsCount;
  }

  public Integer getPostsCount() {
    return postsCount;
  }

  public void setPostsCount(Integer postsCount) {
    this.postsCount = postsCount;
  }

  public Long getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Long creationDate) {
    this.creationDate = creationDate;
  }

  public Long getVacationDate() {
    return vacationDate;
  }

  public void setVacationDate(Long vacationDate) {
    this.vacationDate = vacationDate;
  }

  @Override
  public String toString() {
    return "UserInformation{" +
        "username='" + username + '\'' +
        ", gravatar='" + gravatar + '\'' +
        ", level=" + level +
        ", title='" + title + '\'' +
        ", about='" + about + '\'' +
        ", website='" + website + '\'' +
        ", twitter='" + twitter + '\'' +
        ", topicsCount=" + topicsCount +
        ", postsCount=" + postsCount +
        ", creationDate=" + creationDate +
        ", vacationDate=" + vacationDate +
        '}';
  }
}
