package com.wanikani.api.model;

public class SrsDistribution {

  private Level apprentice;
  private Level guru;
  private Level master;
  private Level enlighten;
  private Level burned;

  public SrsDistribution() {
  }

  public Level getApprentice() {
    return apprentice;
  }

  public void setApprentice(Level apprentice) {
    this.apprentice = apprentice;
  }

  public Level getGuru() {
    return guru;
  }

  public void setGuru(Level guru) {
    this.guru = guru;
  }

  public Level getMaster() {
    return master;
  }

  public void setMaster(Level master) {
    this.master = master;
  }

  public Level getEnlighten() {
    return enlighten;
  }

  public void setEnlighten(Level enlighten) {
    this.enlighten = enlighten;
  }

  public Level getBurned() {
    return burned;
  }

  public void setBurned(Level burned) {
    this.burned = burned;
  }

  @Override
  public String toString() {
    return "SrsDistribution{" +
        "apprentice=" + apprentice +
        ", guru=" + guru +
        ", master=" + master +
        ", enlighten=" + enlighten +
        ", burned=" + burned +
        '}';
  }
}
