import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Fifteen2 {

  private String[][] board; // actual game board
  private String[][] origin; // winning game board
  private List<String> numList = new ArrayList<String>();
  private int dim; // board dimension
  private int size = dim * dim; // total number of spaces on board
  private int heuristic = 0;
  private Random random = new Random();

  public Fifteen2() {
    this.init();
  }

  public void init() {
    dim = 4;
    board = new String[dim][dim];
    int num = 0;
    String numString = "";
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        if (num == 0){
          numString = "00";
        }
        else if (num > 0 && num < 10) {
          numString = "0" + Integer.toString(num);
        }
        else {
          numString = Integer.toString(num);
        }
        board[x][y] = numString;
        numList.add(numString);
        num++;
      }
    }
    origin = board;
  }

  public String toString() {
    // String s = "\n";
    String s = "";
    int count = 1;
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        s += board[x][y] + " ";
        if (count % 4 == 0) {
          s += "\n";
        }
        count++;
      }
    }
    return s;
  }

  public void shuffle() {
    Collections.shuffle(numList);
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        board[j][i] = numList.get(j + i * dim);
      }
    }
    System.out.println("SHUFFLED!");
  }

  public void smartShuffle() {
    Random randShuffle = new Random();
    Random tile = new Random();
    for (int i = 0; i < 100; i++){
      String coord = getCoord(board, tile.nextInt(16));
      int x = Integer.parseInt(coord.substring(0, 1));
      int y = Integer.parseInt(coord.substring(1));
      int z = moveLimit(coord);
      int move = randShuffle.nextInt(4);

      // System.out.println("Move limit: " + z);
      // System.out.println("Coordinate: " + x + ", " + y);

      // 0: move up
      if (move == 0 && z != 2 && z != 8 && z != 10) {
        swap(x, y, x, y - 1);
      }
      // 1: move down
      else if (move == 1 && z % 3 != 0) {
        swap(x, y, x, y + 1);
      }
      // 2: move right
      else if (move == 2 && z % 4 != 0) {
        swap(x, y, x + 1, y);
      }
      // 3: move left
      else if (move == 3 && z % 5 != 0) {
        swap(x, y, x - 1, y);
      }
    }
  }

  // x1, y1 is swapped with x2, y2
  public void swap(int x1, int y1, int x2, int y2) {
    String hold = board[x2][y2];
    board[x2][y2] = board[x1][y1];
    board[x1][y1] = hold;
  }

  public int moveLimit(String coord) {
    int x = Integer.parseInt(coord.substring(0, 1));
    int y = Integer.parseInt(coord.substring(1));
    int limit = 1;
    int special = 1;
    if (dim > 1) {
      // 1: top restriction
      if (y == 0) {
        limit = 2; //2,8,10
      }
      // 2: bottom restriction
      if (y == dim - 1) {
        limit = 3; // 3,12,15
      }
      // 3: right restriction
      if (x == dim - 1) {
        special = 4; // 4,8,12
      }
      // 4: left restriction
      if (x == 0) {
        special = 5; // 5,10,15
      }
      // 5:
    }

    // System.out.println("in moveLimit: " + limit + "*" + special);
    return limit*special;

  }

  // Checks if two spots are next to each other
  public String isNeighbor(String coord1, String coord2) {
    int x1 = Integer.parseInt(coord1.substring(0, 1));
    int y1 = Integer.parseInt(coord1.substring(1));
    int x2 = Integer.parseInt(coord2.substring(0, 1));
    int y2 = Integer.parseInt(coord2.substring(1));

    if (Math.abs(x1 - x2) == 1 ^ Math.abs(y1 - y2) == 1) {
      return "true";
    }
    return "false";
  }

  // Calculates number of steps to get to a certain spot
  public int manhattanDist(String coord1, String coord2) {
    int x1 = Integer.parseInt(coord1.substring(0, 1));
    int y1 = Integer.parseInt(coord1.substring(1));
    int x2 = Integer.parseInt(coord2.substring(0, 1));
    int y2 = Integer.parseInt(coord2.substring(1));
    System.out.println("Coord2: " + x2 + ", " + y2);
    int s = x1 - x2;
    System.out.println("abs val: " + s);
    // System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
    // return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    return x1 - x2;
  }

  public int totalDist() {
    int sum = 0;
    String coord1, coord2;
    for (int i = 0; i < size; i++) {
      coord1 = getCoord(origin, i);
      coord2 = getCoord(board, i);
      sum += manhattanDist(coord1, coord2);
    }
    // System.out.println(sum);
    heuristic = sum;
    return sum;
  }

  // Heuristically solves the 15 Puzzle
  public void solve() {
    System.out.println("solve");
  }

  // Returns coordinates of a number in an array in the form "xy"
  public String getCoord(String[][] array, int num) {
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        if (Integer.parseInt(array[j][i]) == num) {
          return Integer.toString(j) + Integer.toString(i);
        }
      }
    }
    return "NaN";
  }

  public static void main(String[] args) {
    Fifteen2 f = new Fifteen2();
    System.out.println();
    System.out.println("Original Board");
    System.out.println(f);
    System.out.println("Shuffled Board");
    f.smartShuffle();
    System.out.println(f);
    f.manhattanDist(f.getCoord(f.origin, 4), f.getCoord(f.board, 4));
    f.totalDist();
    System.out.println(f.heuristic);
    f.solve();
  }

}
