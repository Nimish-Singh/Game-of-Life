package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.pathashala.GameOfLife.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest {
  @Test
  void expectGridForGivenOnePoint() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    Cell aCell = new Cell(9, 9);
    cellList.add(aCell);
    Set<Cell> initialUniverse = new HashSet<>(cellList);
    assertEquals(new Universe(initialUniverse), game.createSeed(cellList));
  }

  @Test
  void expectGridForGivenTwoPoints() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    Cell aCell = new Cell(9, 9);
    Cell anotherCell = new Cell(9, 8);
    cellList.add(aCell);
    cellList.add(anotherCell);
    Set<Cell> initialUniverse = new HashSet<>(cellList);
    assertEquals(new Universe(initialUniverse), game.createSeed(cellList));
  }

  @Test
  void expectSinglePointPatternToGiveNoSurvivingCell() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    Universe initial = game.createSeed(cellList);
    Set<Cell> empty = new HashSet<>();
    assertEquals(new Universe(empty), game.tick(initial));
  }

  @Test
  void expectBlockPatternToGiveStillLifeOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 2));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(2, 2));
    Universe initial = game.createSeed(cellList);
    Set<Cell> latter = new HashSet<>();
    latter.add(new Cell(1, 1));
    latter.add(new Cell(1, 2));
    latter.add(new Cell(2, 1));
    latter.add(new Cell(2, 2));
    assertEquals(new Universe(latter), game.tick(initial));
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
    Universe initial = game.createSeed(cellList);
    Set<Cell> latter = new HashSet<>();
    latter.add(new Cell(0, 1));
    latter.add(new Cell(1, 0));
    latter.add(new Cell(2, 1));
    latter.add(new Cell(0, 2));
    latter.add(new Cell(1, 2));
    assertEquals(new Universe(latter), game.tick(initial));
  }

  @Test
  void expectBlinkerPatternToGiveOscillatorOutput() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(1, 2));
    Universe initial = game.createSeed(cellList);
    Set<Cell> latter = new HashSet<>();
    latter.add(new Cell(1, 1));
    latter.add(new Cell(0, 1));
    latter.add(new Cell(2, 1));
    assertEquals(new Universe(latter), game.tick(initial));
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
    Universe initial = game.createSeed(cellList);
    Set<Cell> latter = new HashSet<>();
    latter.add(new Cell(0, 2));
    latter.add(new Cell(1, 1));
    latter.add(new Cell(1, 4));
    latter.add(new Cell(2, 1));
    latter.add(new Cell(2, 4));
    latter.add(new Cell(3, 3));
    assertEquals(new Universe(latter), game.tick(initial));
  }

  @Test
  void expectBlockPatternToBeTermedAsStable() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 2));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(2, 2));
    Universe initial = game.createSeed(cellList);
    assertEquals(STABLE_PATTERN, game.patternType(initial));
  }

  @Test
  void expectBlinkerPatternToBeTermedAsRepeating() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(1, 2));
    Universe initial = game.createSeed(cellList);
    assertEquals(REPEATING_PATTERN, game.patternType(initial));
  }

  @Test
  void expectRandomPatternToBeTermedAsNoneOfTheTwo() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(3, 0));
    cellList.add(new Cell(5, 2));
    Universe initial = game.createSeed(cellList);
    assertEquals(NEITHER_STABLE_NOR_REAPEATING, game.patternType(initial));
  }

  @Test
  void expectToReceiveNumberOfGenerationsNeededForRepetitionForBlinkerPattern() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(1, 2));
    Universe initial = game.createSeed(cellList);
    assertEquals(REPETITION_PATTERN_GENERATION_NUMBER + "2", game.numberOfGenerationsNeededToBecomeRepeatingPattern(initial));
  }

  @Test
  void expectToReceiveNumberOfGenerationsNeededForStabilityForBlockPattern() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(2, 2));
    cellList.add(new Cell(1, 2));
    cellList.add(new Cell(2, 1));
    Universe initial = game.createSeed(cellList);
    assertEquals(STABLE_PATTERN_GENERATION_NUMBER + "1", game.numberOfGenerationsNeededToBecomeStablePattern(initial));
  }

  @Test
  void expectBlinkerPatternNotToBecomeStable() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(1, 0));
    cellList.add(new Cell(1, 2));
    Universe initial = game.createSeed(cellList);
    assertEquals(NO_STABILITY_AFTER_DECIDED_NUMBER_OF_GENERATIONS, game.numberOfGenerationsNeededToBecomeStablePattern(initial));
  }

  @Test
  void expectGliderPatternNotToBecomeRepeating() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(3, 1));
    cellList.add(new Cell(3, 2));
    cellList.add(new Cell(2, 3));
    Universe initial = game.createSeed(cellList);
    assertEquals(NO_REPETITION_AFTER_DECIDED_NUMBER_OF_GENERATIONS, game.numberOfGenerationsNeededToBecomeRepeatingPattern(initial));
  }

  @Test
  void expectGliderPatternNotToBecomeStable() {
    GameOfLife game = new GameOfLife();
    ArrayList<Cell> cellList = new ArrayList<>();
    cellList.add(new Cell(1, 1));
    cellList.add(new Cell(2, 1));
    cellList.add(new Cell(3, 1));
    cellList.add(new Cell(3, 2));
    cellList.add(new Cell(2, 3));
    Universe initial = game.createSeed(cellList);
    assertEquals(NO_STABILITY_AFTER_DECIDED_NUMBER_OF_GENERATIONS, game.numberOfGenerationsNeededToBecomeStablePattern(initial));
  }
}