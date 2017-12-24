package com.pathashala;

import java.util.ArrayList;

//Represents the smallest unit on a 2-D grid
public class Cell {
  private final int xCoordinate;
  private final int yCoordinate;

  Cell(int xCoordinate, int yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  ArrayList<Cell> neighbours() {
    ArrayList<Cell> neighbours = new ArrayList<>();
    for (int i = xCoordinate - 1; i <= xCoordinate + 1; i++) {
      for (int j = yCoordinate - 1; j <= yCoordinate + 1; j++) {
        neighbours.add(new Cell(i, j));
      }
    }
    neighbours.remove(this);
    return neighbours;
  }

  @Override
  public String toString() {
    return (xCoordinate + ", " + yCoordinate);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Cell anotherCell = (Cell) other;
    if (xCoordinate != anotherCell.xCoordinate) {
      return false;
    }
    return yCoordinate == anotherCell.yCoordinate;
  }

  @Override
  public int hashCode() {
    int result = xCoordinate;
    result = 31 * result + yCoordinate;
    return result;
  }
}