package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest {
  @Test
  void expectGridForGivenOnePoint() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    Cell aCell = new Cell(9, 9);
    cellList.add(aCell);
    HashMap<Cell, CellStatus> map = new HashMap<>();
    map.put(aCell, new CellStatus(true));
    ArrayList<Cell> neighbours = aCell.neighbours();
    neighbours.forEach(neighbour -> map.put(neighbour, new CellStatus(false)));
    assertEquals(new Grid(map), game.createSeed(cellList));
  }

  @Test
  void expectGridForGivenTwoPoints() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    Cell aCell = new Cell(9, 9);
    Cell anotherCell = new Cell(9, 8);
    cellList.add(aCell);
    cellList.add(anotherCell);
    HashMap<Cell, CellStatus> map = new HashMap<>();
    map.put(aCell, new CellStatus(true));
    map.put(anotherCell, new CellStatus(true));
    ArrayList<Cell> neighbours = aCell.neighbours();
    neighbours.addAll(anotherCell.neighbours());
    for (Cell neighbour : neighbours) {
      if (map.containsKey(neighbour)) {
        continue;
      }
      map.put(neighbour, new CellStatus(false));
    }
    assertEquals(new Grid(map), game.createSeed(cellList));
  }

  @Test
  void expectSinglePointPatternToGiveNoSurvivingCell() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    Grid initial = game.createSeed(cellList);
    HashMap<Cell, CellStatus> empty = new HashMap<>();
    assertEquals(new Grid(empty), game.tick(initial));
  }

  @Test
  void expectBlockPatternToGiveStillLifeOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 2));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(2, 2));
    Grid initial = game.createSeed(cellList);
    HashMap<Cell, CellStatus> latter = new HashMap<>();
    latter.put(new Cell(1, 1), new CellStatus(true));
    latter.put(new Cell(1, 2), new CellStatus(true));
    latter.put(new Cell(2, 1), new CellStatus(true));
    latter.put(new Cell(2, 2), new CellStatus(true));
    assertEquals(new Grid(latter), game.tick(initial));
  }

  @Test
  void expectBoatPatternToGiveStillLifeOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(0, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(0, 2));
    cellList.add(new Cell(1, 2));
    Grid initial = game.createSeed(cellList);
    HashMap<Cell, CellStatus> latter = new HashMap<>();
    latter.put(new Cell(0, 1), new CellStatus(true));
    latter.put(new Cell(1, 0), new CellStatus(true));
    latter.put(new Cell(2, 1), new CellStatus(true));
    latter.put(new Cell(0, 2), new CellStatus(true));
    latter.put(new Cell(1, 2), new CellStatus(true));
    assertEquals(new Grid(latter), game.tick(initial));
  }

  @Test
  void expectBlinkerPatternToGiveOscillatorOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(1, 2));
    Grid initial = game.createSeed(cellList);
    HashMap<Cell, CellStatus> latter = new HashMap<>();
    latter.put(new Cell(1, 1), new CellStatus(true));
    latter.put(new Cell(0, 1), new CellStatus(true));
    latter.put(new Cell(2, 1), new CellStatus(true));
    assertEquals(new Grid(latter), game.tick(initial));
  }

  @Test
  void expectToadPatternToGiveTwoPhaseOscillatorOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 2));
    cellList.add(new Cell(1, 3));
    cellList.add(new Cell(2, 2));
    cellList.add(new Cell(2, 3));
    cellList.add(new Cell(2, 4));
    Grid initial = game.createSeed(cellList);
    HashMap<Cell, CellStatus> latter = new HashMap<>();
    latter.put(new Cell(0, 2), new CellStatus(true));
    latter.put(new Cell(1, 1), new CellStatus(true));
    latter.put(new Cell(1, 4), new CellStatus(true));
    latter.put(new Cell(2, 1), new CellStatus(true));
    latter.put(new Cell(2, 4), new CellStatus(true));
    latter.put(new Cell(3, 3), new CellStatus(true));
    assertEquals(new Grid(latter), game.tick(initial));
  }
}