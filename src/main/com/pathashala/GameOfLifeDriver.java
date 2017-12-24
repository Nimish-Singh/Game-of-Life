package com.pathashala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Represents utility function to play Game of Life
public class GameOfLifeDriver {
  public static void main(String[] args) {
    GameOfLife game = new GameOfLife();
    List<Cell> cellList = takeInput();
    Grid initial = game.createSeed(cellList);
    Grid afterTick = game.tick(initial);
    afterTick.show();
  }

  static private List<Cell> takeInput() {
    List<Cell> cellList = new ArrayList<>();
    boolean shouldTakeInput = true;
    Scanner scanner = new Scanner(System.in);
    while (shouldTakeInput) {
      String input = scanner.nextLine();
      if (input.equals("")) {
        shouldTakeInput = false;
        continue;
      }
      String[] coordinates = input.split(",");
      Cell cell = new Cell(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
      cellList.add(cell);
    }
    scanner.close();
    return cellList;
  }
}
