package com.pathashala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Represents an activity where initial seed can be changed to another state via a tick
public class GameOfLife {
  Grid createSeed(List<Cell> cellList) {
    HashMap<Cell, CellStatus> state = new HashMap<>();
    for (Cell cell : cellList) {
      state.put(cell, new CellStatus(true));
      ArrayList<Cell> neighbours = cell.neighbours();
      for (Cell neighbour : neighbours) {
        if (!state.containsKey(neighbour)) {
          state.put(neighbour, new CellStatus(false));
        }
      }
    }
    return new Grid(state);
  }

  Grid tick(Grid initialGrid) {
    return initialGrid.changeState();
  }
}