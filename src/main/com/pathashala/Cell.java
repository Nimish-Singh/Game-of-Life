package com.pathashala;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
    IntStream.range(-1, 2)
            .forEach(row -> IntStream.range(-1, 2)
                    .forEach(column -> neighbours
                            .add(new Cell(xCoordinate + row, yCoordinate + column))));
    neighbours.remove(this);
    return neighbours;
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

  @Override
  public String toString() {
    return (xCoordinate + ", " + yCoordinate + "\t");
  }
}