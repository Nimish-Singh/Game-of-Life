package com.pathashala;

//Represents the living state of a cell
public class Status {
  private final boolean alive;

  Status(boolean alive) {
    this.alive = alive;
  }

  boolean isAlive() {
    return alive == true;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Status otherStatus = (Status) other;
    return alive == otherStatus.alive;
  }

  @Override
  public int hashCode() {
    return (alive ? 1 : 0);
  }
}