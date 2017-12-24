package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
  @Test
  void expectCorrectNeighboursForCellAt_0_0_() {
    int xCoordinate = 0;
    int yCoordinate = 0;
    Cell aCell = new Cell(xCoordinate, yCoordinate);
    ArrayList<Cell> neighbours = new ArrayList<>();
    for (int i = xCoordinate - 1; i <= xCoordinate + 1; i++) {
      for (int j = yCoordinate - 1; j <= yCoordinate + 1; j++) {
        neighbours.add(new Cell(i, j));
      }
    }
    neighbours.remove(aCell);
    assertEquals(neighbours, aCell.neighbours());
  }

  @Test
  void expectCorrectNeighboursForCellAt_3_4_() {
    int xCoordinate = 3;
    int yCoordinate = 4;
    Cell aCell = new Cell(xCoordinate, yCoordinate);
    ArrayList<Cell> neighbours = new ArrayList<>();
    for (int i = xCoordinate - 1; i <= xCoordinate + 1; i++) {
      for (int j = yCoordinate - 1; j <= yCoordinate + 1; j++) {
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