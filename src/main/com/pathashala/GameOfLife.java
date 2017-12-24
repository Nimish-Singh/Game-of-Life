package com.pathashala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Represents an activity where initial seed can be changed to another state via a tick
public class GameOfLife {
  Grid createSeed(List<Cell> cellList) {
    HashMap<Cell, Status> state = new HashMap<>();
    cellList.forEach(cell -> {
      state.put(cell, new Status(true));
      ArrayList<Cell> neighbours = cell.neighbours();
      neighbours.stream().filter(neighbour -> !state.containsKey(neighbour)).forEach(neighbour -> state.put(neighbour, new Status(false)));
    });
    return new Grid(state);
  }

  Grid tick(Grid initialGrid) {
    return initialGrid.changeState();
  }
}