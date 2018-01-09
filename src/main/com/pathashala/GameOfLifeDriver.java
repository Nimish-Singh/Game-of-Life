package com.pathashala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Represents utility function to play Game of Life
public class GameOfLifeDriver {
  public static void main(String[] args) {
    GameOfLife game = new GameOfLife();
    List<Cell> cellList = takeInput();
    Universe initial = game.createSeed(cellList);
    Universe afterTick = game.tick(initial);
    afterTick.show();
    System.out.println(game.patternType(initial));
    System.out.println(game.numberOfGenerationsNeededToBecomeStablePattern(initial));
    System.out.println(game.numberOfGenerationsNeededToBecomeRepeatingPattern(initial));
  }

  static private List<Cell> takeInput() {
    List<Cell> cellList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("")) {
        scanner.close();
        return cellList;
      }
      String[] coordinates = input.split(",");
      Cell cell = new Cell(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
      cellList.add(cell);
    }
  }
}