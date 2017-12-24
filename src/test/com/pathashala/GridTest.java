package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GridTest {
  @Test
  void expectEmptyGridAfterTickIfItHasSingleCell() {
    HashMap<Cell, CellStatus> seed = new HashMap<>();
    seed.put(new Cell(1, 1), new CellStatus(true));
    Grid initial = new Grid(seed);
    HashMap<Cell, CellStatus> empty = new HashMap<>();
    assertEquals(new Grid(empty), initial.changeState());
  }

  @Test
  void expectSameGridAfterTickIfItHasFourNeighbouringCells() {
    HashMap<Cell, CellStatus> seed = new HashMap<>();
    seed.put(new Cell(1, 1), new CellStatus(true));
    seed.put(new Cell(1, 2), new CellStatus(true));
    seed.put(new Cell(2, 1), new CellStatus(true));
    seed.put(new Cell(2, 2), new CellStatus(true));
    Grid initial = new Grid(seed);
    assertEquals(new Grid(seed), initial.changeState());
  }

  @Test
  void expectEqualSeedsToGiveEqualGrids() {
    HashMap<Cell, CellStatus> aMap = new HashMap<>();
    aMap.put(new Cell(1, 1), new CellStatus(true));
    aMap.put(new Cell(2, 2), new CellStatus(true));
    HashMap<Cell, CellStatus> anotherMap = new HashMap<>();
    anotherMap.put(new Cell(1, 1), new CellStatus(true));
    anotherMap.put(new Cell(2, 2), new CellStatus(true));
    assertEquals(new Grid(aMap), new Grid(anotherMap));
  }

  @Test
  void expectUnequalSeedsToGiveUnequalGrids() {
    HashMap<Cell, CellStatus> aMap = new HashMap<>();
    aMap.put(new Cell(1, 1), new CellStatus(true));
    aMap.put(new Cell(2, 2), new CellStatus(true));
    HashMap<Cell, CellStatus> anotherMap = new HashMap<>();
    anotherMap.put(new Cell(2, 1), new CellStatus(true));
    anotherMap.put(new Cell(2, 2), new CellStatus(true));
    assertNotEquals(new Grid(aMap), new Grid(anotherMap));
  }
}