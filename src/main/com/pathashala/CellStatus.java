package com.pathashala;

//Represents the living state of a cell
public class CellStatus {
  private final boolean alive;

  CellStatus(boolean alive) {
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
    CellStatus otherStatus = (CellStatus) other;
    return alive == otherStatus.alive;
  }

  @Override
  public int hashCode() {
    return (alive ? 1 : 0);
  }
}