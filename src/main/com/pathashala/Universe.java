package com.pathashala;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Represents an orthogonal collection of square cells
public class Universe {
  Set<Cell> aliveCells;

  Universe(Set<Cell> aliveCells) {
    this.aliveCells = new HashSet<>(aliveCells);
  }

  Universe nextGeneration() {
    Set<Cell> cellNeighbours = collectNeighbours();
    Set<Cell> cellsThatSurvive = cellsThatSurvive();
    Set<Cell> cellsThatShouldBeBorn = cellsThatShouldBeBorn(cellNeighbours);
    Set<Cell> nextGenerationCells = new HashSet<>();
    nextGenerationCells.addAll(cellsThatSurvive);
    nextGenerationCells.addAll(cellsThatShouldBeBorn);
    return new Universe(nextGenerationCells);
  }

  private Set<Cell> collectNeighbours() {
    Set<Cell> neighbours = new HashSet<>();
    aliveCells.stream().map(Cell::neighbours).forEach(neighbours::addAll);
    return neighbours;
  }

  private Set<Cell> cellsThatSurvive() {
    Set<Cell> survivingCells = aliveCells.stream().filter(this::shouldSurvive).collect(Collectors.toSet());
    return survivingCells;
  }

  private boolean shouldSurvive(Cell cell) {
    List<Cell> neighbours = cell.neighbours();
    int count = (int) neighbours.stream().filter(neighbour -> aliveCells.contains(neighbour)).count();
    return count > 1 && count < 4;
  }

  private Set<Cell> cellsThatShouldBeBorn(Set<Cell> cellNeighbours) {
    Set<Cell> cellsToMakeAlive = cellNeighbours.stream().filter(this::shouldComeToLife).collect(Collectors.toSet());
    return cellsToMakeAlive;
  }

  private boolean shouldComeToLife(Cell cell) {
    List<Cell> neighbours = cell.neighbours();
    int count = (int) neighbours.stream().filter(neighbour -> aliveCells.contains(neighbour)).count();
    return count == 3;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Universe otherUniverse = (Universe) other;
    return aliveCells != null ? aliveCells.equals(otherUniverse.aliveCells) : otherUniverse.aliveCells == null;
  }

  @Override
  public int hashCode() {
    return aliveCells != null ? aliveCells.hashCode() : 0;
  }

  void show() {
    aliveCells.forEach(System.out::println);
  }
}