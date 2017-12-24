package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GridTest {
  @Test
  void expectEmptyGridAfterTickIfItHasSingleCell() {
    HashMap<Cell, Status> seed = new HashMap<>();
    seed.put(new Cell(1, 1), new Status(true));
    Grid initial = new Grid(seed);
    HashMap<Cell, Status> empty = new HashMap<>();
    assertEquals(new Grid(empty), initial.changeState());
  }

  @Test
  void expectSameGridAfterTickIfItHasFourNeighbouringCells() {
    HashMap<Cell, Status> seed = new HashMap<>();
    seed.put(new Cell(1, 1), new Status(true));
    seed.put(new Cell(1, 2), new Status(true));
    seed.put(new Cell(2, 1), new Status(true));
    seed.put(new Cell(2, 2), new Status(true));
    Grid initial = new Grid(seed);
    assertEquals(new Grid(seed), initial.changeState());
  }

  @Test
  void expectEqualSeedsToGiveEqualGrids() {
    HashMap<Cell, Status> aMap = new HashMap<>();
    aMap.put(new Cell(1, 1), new Status(true));
    aMap.put(new Cell(2, 2), new Status(true));
    HashMap<Cell, Status> anotherMap = new HashMap<>();
    anotherMap.put(new Cell(1, 1), new Status(true));
    anotherMap.put(new Cell(2, 2), new Status(true));
    assertEquals(new Grid(aMap), new Grid(anotherMap));
  }

  @Test
  void expectUnequalSeedsToGiveUnequalGrids() {
    HashMap<Cell, Status> aMap = new HashMap<>();
    aMap.put(new Cell(1, 1), new Status(true));
    aMap.put(new Cell(2, 2), new Status(true));
    HashMap<Cell, Status> anotherMap = new HashMap<>();
    anotherMap.put(new Cell(2, 1), new Status(true));
    anotherMap.put(new Cell(2, 2), new Status(true));
    assertNotEquals(new Grid(aMap), new Grid(anotherMap));
  }
}