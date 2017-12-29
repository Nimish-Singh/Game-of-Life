package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UniverseTest {
  @Test
  void expectEmptyUniverseAfterTickIfItHasSingleCell() {
    Set<Cell> seed = new HashSet<>();
    seed.add(new Cell(1, 1));
    Universe initial = new Universe(seed);
    Set<Cell> empty = new HashSet<>();
    assertEquals(new Universe(empty), initial.nextGeneration());
  }

  @Test
  void expectSameUniverseAfterTickIfItHasFourNeighbouringCells() {
    Set<Cell> seed = new HashSet<>();
    seed.add(new Cell(1, 1));
    seed.add(new Cell(1, 2));
    seed.add(new Cell(2, 1));
    seed.add(new Cell(2, 2));
    Universe initial = new Universe(seed);
    assertEquals(new Universe(seed), initial.nextGeneration());
  }

  @Test
  void expectEqualSeedsToGiveEqualUniverses() {
    Set<Cell> aSet = new HashSet<>();
    aSet.add(new Cell(1, 1));
    aSet.add(new Cell(2, 2));
    Set<Cell> anotherSet = new HashSet<>();
    anotherSet.add(new Cell(1, 1));
    anotherSet.add(new Cell(2, 2));
    assertEquals(new Universe(aSet), new Universe(anotherSet));
  }

  @Test
  void expectUnequalSeedsToGiveUnequalUniverses() {
    Set<Cell> aSet = new HashSet<>();
    aSet.add(new Cell(1, 1));
    aSet.add(new Cell(2, 2));
    Set<Cell> anotherSet = new HashSet<>();
    anotherSet.add(new Cell(2, 1));
    anotherSet.add(new Cell(2, 2));
    assertNotEquals(new Universe(aSet), new Universe(anotherSet));
  }

  @Test
  void expectEqualHashcodesForEqualUniverses() {
    Set<Cell> aSet = new HashSet<>();
    aSet.add(new Cell(1, 1));
    aSet.add(new Cell(2, 2));
    Set<Cell> anotherSet = new HashSet<>();
    anotherSet.add(new Cell(1, 1));
    anotherSet.add(new Cell(2, 2));
    assertEquals(new Universe(aSet).hashCode(), new Universe(anotherSet).hashCode());
  }

  @Test
  void expectUnequalHashcodesForUnequalUniverses() {
    Set<Cell> aSet = new HashSet<>();
    aSet.add(new Cell(1, 1));
    aSet.add(new Cell(2, 2));
    Set<Cell> anotherSet = new HashSet<>();
    anotherSet.add(new Cell(2, 1));
    anotherSet.add(new Cell(2, 2));
    assertNotEquals(new Universe(aSet).hashCode(), new Universe(anotherSet).hashCode());
  }
}