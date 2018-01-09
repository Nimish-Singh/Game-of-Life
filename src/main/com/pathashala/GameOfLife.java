package com.pathashala;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Represents an activity where initial seed can be changed to another state via a tick
class GameOfLife {

  static final String REPEATING_PATTERN = "Repeating";
  static final String STABLE_PATTERN = "Stable";
  static final String NEITHER_STABLE_NOR_REAPEATING = "Neither stable nor repeating";
  static final String REPETITION_PATTERN_GENERATION_NUMBER = "This pattern repeats after generations:";
  static final String NO_REPETITION_AFTER_DECIDED_NUMBER_OF_GENERATIONS = "This pattern doesn't become repeating within 10 generations";
  static final int NUMBER_OF_TEST_GENERATIONS = 10;
  static final String STABLE_PATTERN_GENERATION_NUMBER = "This pattern becomes stable after generations:";
  static final String NO_STABILITY_AFTER_DECIDED_NUMBER_OF_GENERATIONS = "This pattern doesn't become stable within 10 generations";

  Universe createSeed(List<Cell> cellList) {
    Set<Cell> initialGeneration = new HashSet<>(cellList);
    return new Universe(initialGeneration);
  }

  Universe tick(Universe initialUniverse) {
    return initialUniverse.nextGeneration();
  }

  String patternType(Universe initialUniverse) {
    Universe firstGeneration = tick(initialUniverse);
    Universe secondGeneration = tick(firstGeneration);
    if (firstGeneration.equals(initialUniverse)) {
      return STABLE_PATTERN;
    }
    if (secondGeneration.equals(initialUniverse)) {
      return REPEATING_PATTERN;
    }
    return NEITHER_STABLE_NOR_REAPEATING;
  }

  String numberOfGenerationsNeededToBecomeRepeatingPattern(Universe initialUniverse) {
    Universe[] generations = new Universe[NUMBER_OF_TEST_GENERATIONS];
    generations[0] = tick(initialUniverse);
    for (int i = 1; i < generations.length; i++) {
      generations[i] = tick(generations[i - 1]);
      if (generations[i].equals(generations[0])) {
        return REPETITION_PATTERN_GENERATION_NUMBER + Integer.toString(i);
      }
    }
    return NO_REPETITION_AFTER_DECIDED_NUMBER_OF_GENERATIONS;
  }

  String numberOfGenerationsNeededToBecomeStablePattern(Universe initialUniverse) {
    Universe[] generations = new Universe[NUMBER_OF_TEST_GENERATIONS];
    generations[0] = tick(initialUniverse);
    for (int i = 1; i < generations.length; i++) {
      generations[i] = tick(generations[i - 1]);
      if (generations[i].equals(generations[i - 1])) {
        return STABLE_PATTERN_GENERATION_NUMBER + Integer.toString(i);
      }
    }
    return NO_STABILITY_AFTER_DECIDED_NUMBER_OF_GENERATIONS;
  }
}