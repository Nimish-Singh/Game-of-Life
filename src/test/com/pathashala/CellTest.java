package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CellTest {
  @Test
  void expectCorrectNeighboursForCellAt_0_0_() {
    int xCoordinate = 0;
    int yCoordinate = 0;
    Cell aCell = new Cell(xCoordinate, yCoordinate);
    ArrayList<Cell> neighbours = new ArrayList<>();
    neighbours.add(new Cell(-1, -1));
    neighbours.add(new Cell(-1, 0));
    neighbours.add(new Cell(-1, 1));
    neighbours.add(new Cell(0, -1));
    neighbours.add(new Cell(0, 1));
    neighbours.add(new Cell(1, -1));
    neighbours.add(new Cell(1, 0));
    neighbours.add(new Cell(1, 1));
    neighbours.remove(aCell);
    assertEquals(neighbours, aCell.neighbours());
  }

  @Test
  void expectCorrectNeighboursForCellAt_3_4_() {
    int xCoordinate = 3;
    int yCoordinate = 4;
    Cell aCell = new Cell(xCoordinate, yCoordinate);
    ArrayList<Cell> neighbours = new ArrayList<>();
    neighbours.add(new Cell(2, 3));
    neighbours.add(new Cell(2, 4));
    neighbours.add(new Cell(2, 5));
    neighbours.add(new Cell(3, 3));
    neighbours.add(new Cell(3, 5));
    neighbours.add(new Cell(4, 3));
    neighbours.add(new Cell(4, 4));
    neighbours.add(new Cell(4, 5));
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