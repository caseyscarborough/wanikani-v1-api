package com.wanikani.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class StatisticsItem extends BaseItem {

  @JsonProperty("user_specific")
  private Statistics statistics;

  public StatisticsItem() {
  }

  public Statistics getStatistics() {
    return statistics;
  }

  public void setStatistics(Statistics statistics) {
    this.statistics = statistics;
  }

  public boolean isUnlocked() {
    return statistics != null;
  }

  @Override
  public String toString() {
    return "StatisticsItem{" +
        "statistics=" + statistics +
        "} " + super.toString();
  }
}
