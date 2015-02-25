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
    String s = "\n";
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
  }

  // x1, y1 is swapped with x2, y2
  public void swap(int x1, int y1, int x2, int y2) {
    String hold = board[x2][y2];
    board[x2][y2] = board[x1][y1];
    board[x1][y1] = hold;
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

  public boolean isSolvable() {
    return false;
  }

  // Calculates number of steps to get to a certain spot
  public int manhattanDist(String coord1, String coord2) {
    int x1 = Integer.parseInt(coord1.substring(0, 1));
    int y1 = Integer.parseInt(coord1.substring(1));
    int x2 = Integer.parseInt(coord2.substring(0, 1));
    int y2 = Integer.parseInt(coord2.substring(1));

    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
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
    System.out.println(f);
    f.shuffle();
    //System.out.println(f.isNeighbor("01", "03"));
    System.out.println(f);
    // System.out.println(f.getCoord(board, 16));

  }

}
