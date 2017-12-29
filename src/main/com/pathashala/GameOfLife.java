package com.pathashala;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Represents an activity where initial seed can be changed to another state via a tick
class GameOfLife {
  Universe createSeed(List<Cell> cellList) {
    Set<Cell> initialGeneration = new HashSet<>(cellList);
    return new Universe(initialGeneration);
  }

  Universe tick(Universe initialUniverse) {
    return initialUniverse.nextGeneration();
  }
}