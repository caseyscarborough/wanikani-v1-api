package com.wanikani.api.model;

public class UserInformation {

  private String username;
  private String gravatar;
  private Integer level;
  private String title;
  private String about;
  private String website;
  private String twitter;
  private Integer topicsCount;
  private Integer postsCount;
  private Long creationDate;
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
