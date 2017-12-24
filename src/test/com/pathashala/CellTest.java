package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
  @Test
  void expectCorrectNeighboursForCellAt_0_0_() {
    Cell aCell = new Cell(0, 0);
    ArrayList<Cell> neighbours = new ArrayList<>();
    for (int i = 0 - 1; i <= 0 + 1; i++) {
      for (int j = 0 - 1; j <= 0 + 1; j++) {
        neighbours.add(new Cell(i, j));
      }
    }
    neighbours.remove(aCell);
    assertEquals(neighbours, aCell.neighbours());
  }

  @Test
  void expectCorrectNeighboursForCellAt_3_4_() {
    Cell aCell = new Cell(3, 4);
    ArrayList<Cell> neighbours = new ArrayList<>();
    for (int i = 3 - 1; i <= 3 + 1; i++) {
      for (int j = 4 - 1; j <= 4 + 1; j++) {
        neighbours.add(new Cell(i, j));
      }
    }
    neighbours.remove(aCell);
    assertEquals(neighbours, aCell.neighbours());
  }

  @Test
  void expectEqualCellsToBeEqual() {
    assertEquals(new Cell(-1, 3), new Cell(-1, 3));
  }

  @Test
  void expectUnequalCellsToBeUnequal() {
    assertNotEquals(new Cell(-1, 3), new Cell(-1, -3));
  }

  @Test
  void expectEqualCellsToHaveEqualHashcode() {
    assertEquals(new Cell(-2, 3).hashCode(), new Cell(-2, 3).hashCode());
  }

  @Test
  void expectUnequalCellsToHaveUnequalHashcode() {
    assertNotEquals(new Cell(-2, 3).hashCode(), new Cell(-2, -3).hashCode());
  }
}