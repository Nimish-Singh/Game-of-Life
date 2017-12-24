package com.pathashala;

import java.util.ArrayList;
import java.util.HashMap;

//Represents an orthogonal collection of square cells
public class Grid {
  private final HashMap<Cell, CellStatus> state;

  Grid(HashMap<Cell, CellStatus> state) {
    this.state = state;
  }

  Grid changeState() {
    HashMap<Cell, CellStatus> newState = new HashMap<>();
    for (Cell cell : state.keySet()) {
      int aliveNeighbourCount = aliveNeighbourCount(cell);
      if (state.get(cell).isAlive()) {
        if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
          newState.put(cell, new CellStatus(true));
        }
      }
      if (!(state.get(cell).isAlive())) {
        if (aliveNeighbourCount == 3) {
          newState.put(cell, new CellStatus(true));
        }
      }
    }
    return new Grid(newState);
  }

  private int aliveNeighbourCount(Cell cell) {
    int aliveNeighbourCount = 0;
    ArrayList<Cell> neighbours = cell.neighbours();
    for (Cell neighbour : neighbours) {
      if (state.containsKey(neighbour)) {
        if (state.get(neighbour).isAlive()) {
          aliveNeighbourCount++;
        }
      }
    }
    return aliveNeighbourCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Grid otherGrid = (Grid) other;
    return state != null ? state.equals(otherGrid.state) : otherGrid.state == null;
  }

  void show() {
    for (Cell cell : state.keySet()) {
      System.out.println("new one " + cell + " is " + state.get(cell));
    }
  }
}