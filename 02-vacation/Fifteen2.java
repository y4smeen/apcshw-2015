import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Fifteen2 {

  private String[][] board; // actual game board
  private String[][] origin; // winning game board
  private List<String> numList = new ArrayList<String>();
  private int dim; // board dimension
  private int size = dim * dim; // total number of spaces on board
  private int heuristic = 0;
  private int totalMoves = 0;
  private int lastMove = 0;
  private Random random = new Random();

  private String[][] test; // try out all moves for heuristic

  public Fifteen2() {
    this.init();
  }

  public void init() {
    dim = 4;
    board = new String[dim][dim];
    origin = new String[dim][dim];
    test = new String[dim][dim];
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
        origin[x][y] = numString;
        test[x][y] = numString;

        numList.add(numString);
        num++;
      }
    }
    // origin = board;
  }

  public String toString() {
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
    // Random tile = new Random();
    for (int i = 0; i < 1000; i++){
      String coord = getCoord(board, 0);
      int x = Integer.parseInt(coord.substring(0, 1));
      int y = Integer.parseInt(coord.substring(1));
      int z = moveLimit(coord);
      int move = randShuffle.nextInt(4);

      // 0: move up
      if (move == 0 && z != 2 && z != 8 && z != 10) {
        swap(board, x, y, x, y - 1);
        swap(test, x, y, x, y - 1);
      }
      // 1: move down
      else if (move == 1 && z % 3 != 0) {
        swap(board, x, y, x, y + 1);
        swap(test, x, y, x, y + 1);
      }
      // 2: move right
      else if (move == 2 && z % 4 != 0) {
        swap(board, x, y, x + 1, y);
        swap(test, x, y, x + 1, y);
      }
      // 3: move left
      else if (move == 3 && z % 5 != 0) {
        swap(board, x, y, x - 1, y);
        swap(test, x, y, x - 1, y);
      }
    }
  }

  // x1, y1 is swapped with x2, y2
  public void swap(String[][] array, int x1, int y1, int x2, int y2) {
    String hold = array[x2][y2];
    array[x2][y2] = array[x1][y1];
    array[x1][y1] = hold;
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
    }
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

    // System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  // Gets total manhattanDists
  public int heuristic(String[][] array) {
    int sum = 0;
    String coord1, coord2;
    // System.out.println("start heuristic");

    for (int i = 0; i < dim*dim; i++) {
      coord1 = getCoord(origin, i);
      coord2 = getCoord(array, i);
      sum += manhattanDist(coord1, coord2);
    }
    heuristic = sum;
    return sum;
  }

  // Finds lowest, >= than 0
  public int findMin(int u, int d, int r, int l) {
    int min = Math.min(Math.min(u, d), Math.min(r, l));
    if (min == u) return 1; // move up
    else if (min == d) return 2; // move down
    else if (min == r) return 3; // move right
    else if (min == l) return 4; // move left
    else return 0;
  }

  // Checks all possible moves to find the lowest manhattanDist
  public int checkNext() {
    String coord = getCoord(board, 0);
    int x = Integer.parseInt(coord.substring(0, 1));
    int y = Integer.parseInt(coord.substring(1));
    int z = moveLimit(coord);

    int u = -1, d = -1, r = -1, l = -1;

    // 0: move up
    if (z != 2 && z != 8 && z != 10) {
      swap(board, x, y, x, y - 1);
      u = heuristic(board);
      swap(board, x, y, x, y - 1);
    }
    // 1: move down
    else if (z % 3 != 0) {
      swap(board, x, y, x, y + 1);
      d = heuristic(board);
      swap(board, x, y, x, y + 1);
    }
    // 2: move right
    else if (z % 4 != 0) {
      swap(board, x, y, x + 1, y);
      r = heuristic(board);
      swap(board, x, y, x + 1, y);
    }
    // 3: move left
    else if (z % 5 != 0) {
      swap(board, x, y, x - 1, y);
      l = heuristic(board);
      swap(board, x, y, x - 1, y);
    }
    return findMin(u, d, r, l);
  }

  // Finds number of possible moves
  public int numMoves() {
    int moves = 4;
    String coord = getCoord(board, 0);
    int x = Integer.parseInt(coord.substring(0, 1));
    int y = Integer.parseInt(coord.substring(1));
    int z = moveLimit(coord);
    if (z == 2 || z == 3) {
      moves = 3;
    }
    else if (z > 3) {
      moves = 2;
    }
    return moves;
  }

  // Heuristically solves the 15 Puzzle
  public void solve() {
    // boolean tryAgain = false;
    String coord = getCoord(board, 0);
    int x = Integer.parseInt(coord.substring(0, 1));
    int y = Integer.parseInt(coord.substring(1));
    boolean done = false;
    while (heuristic(board) > 0) {
      System.out.println("Next move: " + checkNext());
      int n = checkNext();
      while (done = false) {
        if (n == 1 && lastMove != 2) {
          swap(board, x, y, x, y - 1);
          lastMove = 1;
          done = true;
        }
        else if (n == 1 && lastMove == 2) {
          if (x + 1 < dim) n = 3;
          else n = 4;
        }
        else if (n == 2 && lastMove!= 1) {
          swap(board, x, y, x, y + 1);
          lastMove = 2;
          done = true;
        }
        else if(n == 2 && lastMove == 1) {
          if (x + 1 < dim) n = 3;
          else n = 4;
        }
        else if (n == 3 && lastMove != 4) {
          swap(board, x, y, x + 1, y);
          lastMove = 3;
          done = true;
        }
        else if (n == 3 && lastMove == 4) {
          if (y - 1 >= 0) n = 1;
          else n = 2;
        }
        else if (n == 4 && lastMove != 3) {
          swap(board, x, y, x - 1, y);
          lastMove = 4;
          done = true;
        }
        else if (n == 4 && lastMove == 3) {
          if (y - 1 >= 0) n = 1;
          else n = 2;
        }
      }

      totalMoves++;
      System.out.println("Move " + totalMoves);
      System.out.println(this);
      System.out.println("Last Move: " + lastMove);
      //System.out.println()
    }
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
    f.heuristic(f.board);
    // System.out.println(f.heuristic(f.board));
    // System.out.println("Heuristic: " + f.heuristic);
    f.solve();
    // System.out.println(f.findMin(2,1,3,4));
  }

}
