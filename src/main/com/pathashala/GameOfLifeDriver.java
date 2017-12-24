package com.pathashala;

import java.util.ArrayList;

//Represents utility function to play Game of Life
public class GameOfLifeDriver {
  public static void main(String[] args) {
    GameOfLife game = new GameOfLife();

    //Change the following line to alter input
    String[] input = {"1,1", "1,2", "1,0"};

    ArrayList<Cell> cellList = createCellList(input);
    Grid initial = game.createSeed(cellList);
    Grid afterTick = game.tick(initial);
    afterTick.show();
  }

  private static ArrayList<Cell> createCellList(String[] input) {
    ArrayList<Cell> cellList = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      String[] coordinates = input[i].split(",");
      Cell cell = new Cell(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
      cellList.add(cell);
    }
    return cellList;
  }
}
